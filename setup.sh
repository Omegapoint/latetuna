#!/bin/bash

if [ $# -ne 1 ]; then
    echo "Usage: . setup.sh <machine_name>"
    exit 1
fi

MACHINE_NAME=$1
GUI_URL="http://localhost:8080"
export DOCKER_IP=localhost

if [ `uname` = "Darwin" ]; then
    echo "This is MacOS X, doing some setup..."
    eval "$(docker-machine env ${MACHINE_NAME})"
    export DOCKER_IP=`docker-machine ip`
    export KAFKA_ADVERTISED_HOST_NAME=`echo ${DOCKER_HOST} | sed 's/[^0-9]*\([0-9]\{1,3\}\.[0-9]\{1,3\}\.[0-9]\{1,3\}\.[0-9]\{1,3\}\).*/\1/'`
    GUI_URL="http://${DOCKER_IP}:8080"
fi


echo "When started, the GUI can be found here: ${GUI_URL}"
echo "Finished."
