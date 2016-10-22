#!/bin/bash
echo "Depolying Actor finder 1.0"
cp projet/target/projet-1.0-SNAPSHOT.war images/glassfish/
cd topology-amt
docker-compose up --build