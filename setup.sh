#!/bin/bash

if [ $# -ne 1 ]; then
    echo "Usage: . setup.sh <machine_name>"
    return 1
fi

MACHINE_NAME=$1
GUI_URL="http://localhost:3000"

if [ `uname` = "Darwin" ]; then
    echo "This is MacOS X, doing some setup"

    echo -n "Checking if docker machine ${MACHINE_NAME} is running... "
    if [ "$(docker-machine status latetuna)" != "Running" ]; then
        echo "No"
        echo
        echo "*** Start the machine and try again ***"
        echo
        echo "    docker-machine start ${MACHINE_NAME}"
        echo
        return 1
    fi
    echo "Yes"

    echo -n "Setting environment variables... "
    eval "$(docker-machine env ${MACHINE_NAME})"
    export KAFKA_ADVERTISED_HOST_NAME=`echo ${DOCKER_HOST} | sed 's/[^0-9]*\([0-9]\{1,3\}\.[0-9]\{1,3\}\.[0-9]\{1,3\}\.[0-9]\{1,3\}\).*/\1/'`
    GUI_URL="http://${KAFKA_ADVERTISED_HOST_NAME}:3000"
    echo "Ok"
fi

echo "When started, the GUI can be found here: ${GUI_URL}"
echo
echo "Next steps:"
echo "    gradle dockerBuildImage"
echo "    docker-compose build"
echo "    docker-compose up"
echo
echo "Finished."

