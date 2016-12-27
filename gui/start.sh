#!/bin/sh

/bin/filebeat start&
cd /app
node .
