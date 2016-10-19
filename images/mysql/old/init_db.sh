#!/bin/bash
service mysql start &
sleep 10
mysql -u root -p1234 -hlocalhost -e "CREATE DATABASE sakila"
mysql -u root -p1234 sakila < /tmp/sakila-schema.sql
mysql -u root -p1234 sakila < /tmp/sakila-data.sql