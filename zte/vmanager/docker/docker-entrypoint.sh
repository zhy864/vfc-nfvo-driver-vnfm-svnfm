#!/bin/bash

if [ -z "$SERVICE_IP" ]; then
    export SERVICE_IP=`hostname -i`
fi
echo "SERVICE_IP=$SERVICE_IP"

if [ -z "$MSB_ADDR" ]; then
    echo "Missing required variable MSB_ADDR: Microservices Service Bus address <ip>:<port>"
    exit 1
fi
echo "MSB_ADDR=$MSB_ADDR"

# Wait for MSB initialization
echo "Wait for MSB initialization"
for i in {1..5}; do
    curl -sS -m 1 $MSB_PROTO://$MSB_ADDR/msb -k > /dev/null
    res=$?
    if [ $res -ne 0 ]; then
        break
    fi
    sleep $i
done

# Configure service based on docker environment variables
vfc/nfvo/driver/vnfm/svnfm/zte/vmanager/docker/instance_config.sh

# microservice-specific one-time initialization
vfc/nfvo/driver/vnfm/svnfm/zte/vmanager/docker/instance_init.sh

date > init.log

# Start the microservice
vfc/nfvo/driver/vnfm/svnfm/zte/vmanager/docker/instance_run.sh
