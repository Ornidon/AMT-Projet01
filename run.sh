#!/bin/bash
echo "Deploying Actor finder 1.0"
cd projet
mvn clean install
cd ..
cp projet/target/projet-1.0-SNAPSHOT.war images/glassfish/
cd topology-amt
docker-compose up --build

docker-compose down