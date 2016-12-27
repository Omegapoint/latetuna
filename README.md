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
```

Pro tip: Gradle supports camelCased shortcuts, so ```gradle dBI``` works as well!

#### Start all containers
```
docker-compose up
```

## Architecture
![alt tag](docs/latetuna.jpg?raw=true "latetuna")
