# latetuna

In house learning project. The purpose of this project is to investigate and try technology and archtecture that are new to us. The system we're buildning is a conference system. Some of the features we have in mind is:
* create a new conference
* manage a Call For Proposal
* register to a conference
* display a schedule

## Create and activate a docker-machine

#### MacOSX
1. Install VirtualBox: https://www.virtualbox.org/wiki/Downloads
2. Install DockerToolbox: https://www.docker.com/products/docker-toolbox
3. Create a VirtualBox machine to handle latetuna:

```
docker-machine create --driver virtualbox latetuna
```

4. Bootstrap the environment:

```
setup.sh latetuna
```

## Build images

```
gradle dockerBuildImage
```

Pro tip: Gradle supports camelCased shortcuts, so ```gradle dBI``` works as well!

## Start all containers
```
docker-compose up
```

## Architecture
![alt tag](docs/latetuna.jpg?raw=true "latetuna")
