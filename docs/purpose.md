# The purpose

The purpose of this project is to give us the opportunity to explore and try some new techniques, architecture patterns and infrastructure setups. In order to determine some of these things we had an exercise where we all listed methods, techniques and other stuff that we want to explore within this project.

## Architecture

* Microservices
* Event driven messaging
* Event sourcing
* Horizontal scaling
* REST
* Single page application
* Mobile application

## Infrastructure
* Infrastructure as code
* A state of the art build pipeline
* Use docker containers as build artifacts
* Orchestration with Docker Swarm or Kubernetes
* Test data management
* Virtual environment for developers

## Techniques
* Service discovery
* Distributed configuration
* Monitoring metrics
* Logging
* Feature toogles
* Universal Javascript
* Asynchronous execution
* Polyglot services
* Contract testing
* Mutation testing

## Frameworks and libraries
Some of the framworks and libraries that where mentioned during the exercise.

* Jenkins
* Docker Compose
* Docker Swarm
* Kafka
* Elastic
* Gradle
* Spring Boot
* React.js
* RxJava
* Redux
* React Native
* Swift
* Python
* Go
* Pitest
* Pact



## List from exercise (in Swedish)

###### Mattias
* Undersöka komplexiteten som Microservices påför
  * Service discovery
  * Kommunikation mellan tjänster (event eller REST, Kafka)
  * Metrics
  * Loggning (Elastic Stack)
  * Contract testing med t.ex. Pact
* Hur löser man testdata-problematiken
* RxJava
* Feature toggles (Togglez)
* React.js eller cycle.js, webpack
* Universal Javascript
* En fungerande och effektiv CD-pipeline
  * Bygga med gradle
* Docker Compose och Swarm

###### Johan
* Microservices, kanske implementerade mha SpringBoot
* Event Sourcing (CQRS) - (enbart persistera händelserna I varje microservice)
* Köra varje microserver I en container
* Testa fail/over redundans mha docker flow
* Få till ett fungerande CI-flöde I jenkins (som bygger docker-images)
* Få till utvecklingssidan så att man lokalt kan testköra allt (docker-images)

###### Björn
* Microservices, gärna m.h.a. Spring Boot / Spring Cloud
  * Intresserad av tekniker för Contract testing och praktisk administration av detta
  * Event Sourcing
  * Kafka
  * Docker som byggartefakt
  * Deploymentautomation av dockercontrainrar
* Gradledefinitioner med stöd för produktion av multipla testartefakter: integration test suite, unit test suite, ....
* Säkerhet och authentisering i Microservice-arkitekturer
* Pitest (mutation testing)
* Byggpipelineuppsättning
* Vagrant för utvecklingsmiljö(er)
* React/Redux
* React Native
* REST centriska API ramverk på frontendsidan för standardiserad ihoplänkning av resurser?

###### Markus

* AI, machine learning
* Reverse engineering av firmware
* Säkerhetsgranska ett open source-projekt
* IOS-utveckling
* React och React native
* Go
* Python

###### Samuel

* Hur ser en state of the art CI/CD-pipeline ut?
* Hur får man tjänster att hitta och prata med varandra?
* Hur skalar man horisontellt?
* Hur får man bra automatiska tester för samspelet mellan t.ex. en JS-SPA och ett REST-gränssnitt?
* Hur testar man lokalt I en miljö som är så produktionslik som möjligt (på ett smidigt sätt)?
* Hur håller man koll på själva datan när man håller på med containers? Var lagrar man den, hur tar man backup, osv.
* Sen vore det kul med något JS-ramverk som inte är Angular :)
