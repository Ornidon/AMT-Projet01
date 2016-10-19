#!/bin/bash
docker kill $(docker ps -a -q)
docker rm $(docker ps -a -q)
docker rm $(docker images -q)
docker build -t mysqlserver .
docker run -d --name mysqlserver -p3306:3306 -e MYSQL_ROOT_PASSWORD=1234 mysqlserver
sleep 50
docker exec -i mysqlserver mysql -uroot -p1234 < src/sakila-schema.sql
docker exec -i mysqlserver mysql -uroot -p1234 < src/sakila-data.sql