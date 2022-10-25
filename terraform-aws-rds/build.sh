#!/bin/sh
set -e

if [ "$#" -ne 2 ]; then
    echo "Usage: $0 <AWS_ACCESS_KEY> <AWS_SECRET_KEY>"
    exit 1
fi

AWS_ACCESS_KEY="$1"
AWS_SECRET_KEY="$2"

########## Cloud provision #######
cd terraform
terraform init
terraform plan -var AWS_ACCESS_KEY=${AWS_ACCESS_KEY} -var AWS_SECRET_KEY=${AWS_SECRET_KEY} -var DB_NAME=rxjavapoc -var DB_MASTER_USER=rxjavapoc -var DB_MASTER_PASSWORD=rxjavapoc
terraform apply -auto-approve -var AWS_ACCESS_KEY=${AWS_ACCESS_KEY} -var AWS_SECRET_KEY=${AWS_SECRET_KEY} -var DB_NAME=rxjavapoc -var DB_MASTER_USER=rxjavapoc -var DB_MASTER_PASSWORD=rxjavapoc

exit 0