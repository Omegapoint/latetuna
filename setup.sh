#!/bin/bash

if [ $# -ne 1 ]; then
    echo "Usage: . setup.sh <machine_name>"
fi

MACHINE_NAME=$1
GUI_URL="http://localhost:8080"

if [ `uname` = "Darwin" ]; then
    echo "This is MacOS X, doing some setup..."
    eval "$(docker-machine env ${MACHINE_NAME})"
    export KAFKA_ADVERTISED_HOST_NAME=`echo ${DOCKER_HOST} | sed 's/[^0-9]*\([0-9]\{1,3\}\.[0-9]\{1,3\}\.[0-9]\{1,3\}\.[0-9]\{1,3\}\).*/\1/'`
    GUI_URL="http://${KAFKA_ADVERTISED_HOST_NAME}:8080"
fi

echo "When started, the GUI can be found here: ${GUI_URL}"
echo "Finished."
