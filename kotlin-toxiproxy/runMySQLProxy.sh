#!/bin/sh

docker run --rm --name mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -p 3306:3306 -d mysql:8
toxiproxy-server &

mvn compile exec:java -Dexec.mainClass=com.codegik.poc.toxiproxy.MySQLProxyAppKt

docker rm -f mysql
killall toxiproxy-server

exit 0