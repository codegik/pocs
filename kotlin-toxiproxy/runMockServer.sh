#!/bin/sh

mockserver -logLevel DEBUG -serverPort 1080 &

mvn compile exec:java -Dexec.mainClass=com.codegik.poc.toxiproxy.MockServerAppKt

pkill -f mockserver

exit 0