#!/bin/sh
set -e

if [ "$#" -ne 2 ]; then
    echo "Usage: $0 <AWS_ACCESS_KEY> <AWS_SECRET_KEY>"
    exit 1
fi

AWS_ACCESS_KEY="$1"
AWS_SECRET_KEY="$2"

 cd terraform
 terraform destroy -auto-approve -var AWS_ACCESS_KEY=${AWS_ACCESS_KEY} -var AWS_SECRET_KEY=${AWS_SECRET_KEY} -var DB_NAME=r -var DB_MASTER_USER=r -var DB_MASTER_PASSWORD=r

exit 0
