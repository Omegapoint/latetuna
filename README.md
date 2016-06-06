# latetuna
Kompetensprojekt Umeå

## Create and activate a docker-machine

## MacOSX
1. Install VirtualBox: https://www.virtualbox.org/wiki/Downloads
2. Install DockerToolbox: https://www.docker.com/products/docker-toolbox
3. Create a VirtualBox machine to handle latetuna:

```
docker-machine create --driver virtualbox latetuna
```

4. Bootstrap the environment:

```
. setup.sh latetuna
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
