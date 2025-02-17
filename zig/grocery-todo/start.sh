#!/bin/sh

podman rm mysql
podman run --name mysql --env MYSQL_ROOT_PASSWORD=password -p 3306:3306 -d mysql
