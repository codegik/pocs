#!/bin/sh


if [ $# -lt 2 ]; then
  echo ""
  echo "Usage: ./run.sh <user> <accessToken>"
  echo ""
  exit 1
fi

BASEDIR="$( cd -- "$(dirname "$0")" >/dev/null 2>&1 ; pwd -P )"

if ls target/kotlin-github-api-*.jar 1> /dev/null 2>&1; then
    echo "skipping build app"
else
  mvn clean install
fi


java -jar $BASEDIR/target/kotlin-github-api-*.jar --github.user=$1 --github.accessToken=$2

exit 0
