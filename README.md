# latetuna
Kompetensprojekt Umeå

## Create and activate a docker-machine

MacOSX

```docker-machine create --driver virtualbox machine_name```

```eval "$(docker-machine env machine_name)"```

## Start all containers
```docker-compose up```

## Start the whole system (as of 2016-04-08)
1. Start nexus
2. Run "gradle upload" in eventbus-client to make it available
3. Run docker-compose up

## Architecture
![alt tag](docs/latetuna.jpg?raw=true "latetuna")
