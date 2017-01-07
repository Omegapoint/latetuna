# Late Tuna

In house learning project. The purpose of this project is to investigate and try technology and archtecture that are new to us. The system we're buildning is a conference system. Some of the features we have in mind is:
* create a new conference
* manage a Call For Proposal
* register to a conference
* display a schedule

## Create and activate a docker-machine

1. Go to https://www.docker.com/products/docker
1. Download docker for your platform
1. Follow the instructions in the _Getting started tutorial_

#### Build images
```
gradle dockerBuildImage
docker-compose build
```

Pro tip: Gradle supports camelCased shortcuts, so ```gradle dBI``` works as well!

#### Start all containers
```
docker-compose up
```

#### Development tips
* make an alias for docker-compose i.e. `alias dc=docker-compose`
* in order to run services with docker and from your IDE you have to add an alias for kafka to /etc/hosts or equivalent
```
127.0.0.1    kafka
```
* running the gui from the subproject instead from the docker container make the turn around time significant shorter. Run `npm run dev` to start the webpack dev-server



## Architecture
![alt tag](docs/latetuna.jpg?raw=true "latetuna")
