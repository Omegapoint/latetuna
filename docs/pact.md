# Contract testing with Pact

This is a description and a break down on how testing the contract between services in this project is carried out with Pact. It is assumed that the reader has some basic knowledge of Pact. It that isn't the case it is recommended to read the [gitbook](https://docs.pact.io/), [the getting started page](http://dius.com.au/2016/02/03/microservices-pact/) or [watch a presentation](https://www.infoq.com/presentations/pact)

This project uses the following parts of the Pact ecosystem:
* [pact-jvm](https://github.com/DiUS/pact-jvm/)
* [pact-jvm-consumer-junit](https://github.com/DiUS/pact-jvm/tree/master/pact-jvm-consumer-junit)
* [pact-jvm-provider-junit](https://github.com/DiUS/pact-jvm/tree/master/pact-jvm-provider-junit)
* [pact-jvm-provider-gradle](https://github.com/DiUS/pact-jvm/tree/master/pact-jvm-provider-gradle)
* [pact-broker](https://github.com/bethesque/pact_broker)
* [the docker containter for Pact Broker](https://hub.docker.com/r/dius/pact_broker/)

## The general idea

The idea is to have the consumers drive the api of the producer. This is accomplish by letting the consumer provide a contract, a pact, that the producer has to fulfill.

![The idea of pact](https://github.com/realestate-com-au/pact/raw/master/documentation/pact_two_parts.png)

_(image from: https://github.com/realestate-com-au/pact)_


## The consumer
The proposal service is a consumer of the conference service. In order to create a contract between them we write a test in the proposal service that creates a pact-file and tests that it can handle the message from the conference service

 ```java
  	@Pact(provider = "conference", consumer = "proposal")
 	public MessagePact createPact(MessagePactBuilder builder) {
 		PactDslJsonBody body = new PactDslJsonBody();
 		body.stringValue("name", "QCon");
 		body.stringValue("city", "London");

 		Map<String, String> metadata = new HashMap<>();
 		metadata.put("contentType", "application/json");

 		return builder.given("a conference service")
 				.expectsToReceive("when a conference is created it")
 				.withMetadata(metadata)
 				.withContent(body)
 				.toPact();
 	}


	@Test
	@PactVerification("conference")
	public void receiveAConferenceEvent() throws Exception {
		String json = new String(currentMessage);
		assertThat(json).isNotNull();
		ConferenceEvent conferenceEvent = ConferenceEvent.fromJson(json);
		assertThat(conferenceEvent.name()).isEqualTo("QCon");
		assertThat(conferenceEvent.city()).isEqualTo("London");
	}
 ```

We have to invoke the test with gradle in order to create the file

```sh
gradle -q :proposal:test
```

The created pact-file is a json file that specifies the contract between the proposal service and the conference service.

```json
{
    "consumer": {
        "name": "proposal"
    },
    "provider": {
        "name": "conference"
    },
    "messages": [
        {
            "description": "when a conference is created it",
            "contents": {
                "city": "London",
                "name": "QCon"
            },
            "providerState": "a conference service"
        }
    ],
    "metadata": {
        "pact-specification": {
            "version": "3.0.0"
        },
        "pact-jvm": {
            "version": "3.5.0-beta.2"
        }
    }
}
```

In order to make this file accessible from the conference service we have to publish it to the pact broker
```sh
gradle -q :proposal:pactPublish
```

Thats it for the consumer

## The producer

Next we have to verify that our producer, the conference service, fulfills the contract with the proposal service. We can accomplish this with a ordinary junit test.
```java
@PactVerifyProvider("when a conference is created it")
public String verifyCreateConferenceMessage() {
  Conference conference = new Conference("QCon", "London");
  return JsonUtil.toJson(conference);
}
```

To verify the contract run:
```bash
~/Projects/latetuna (pact ✘)✹✭ ᐅ gradle -q :conference:pactVerify
Verifying a pact between proposal and conference
  [from URL http://192.168.99.100/pacts/provider/conference/consumer/proposal/version/0.0.1]
  Given a conference service
  when a conference is created it
    generates a message which
      has a matching body (OK)
```


All nice and dandy


## The setup

Gradle is taking care of glueing this all together, lets see how that is done. First of all, in order to make the build portable one have to set the environment variable DOCKER_IP

```sh
export DOCKER_IP=`docker-machine ip`
```
The `setup.sh`does this and more for you.

#### The pact broker

The pact broker is deployed as a docker container that can be started with
```
docker-compose -d -f build-compose.yml up
```

#### The consumer - proposal service
In addition to include the right dependencies to create the pact-file we have to configure the gradle-plugin so that it can publish the pact-file to the broker

```groovy
pact {
    publish {
        pactDirectory = "${buildDir}/pacts"
        pactBrokerUrl = "http://$System.env.DOCKER_IP:80"
    }
}
```

#### The producer - conference service

We have to configure the conference service to look for annotated test in a specific directory. We also have to tell the plugin to retrieve the pacts from the broker.
```groovy
pact {
    serviceProviders {
        conference {
            verificationType = 'ANNOTATED_METHOD'
            packagesToScan = ['com.omegapoint.latetuna.conference.messages.*']
            hasPactsFromPactBroker("http://$System.env.DOCKER_IP:80")
        }
    }

    reports {
        defaultReports() // adds the standard console output
        markdown // report in markdown format
        json // report in json format
    }
}
```

## The pact broker

Head to the pact broker to see what pacts you have and the dependencies between your different services. The broker will be accessible at http://DOCKER_IP:80
