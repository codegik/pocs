# Postgres RDS provision

## Requirements
To run this provision it is necessary has those tools:
- terraform

You shold have an account on aws and do upload off your public key.

## Perform provisioning
```
./build.sh <AWS_ACCESS_KEY> <AWS_SECRET_KEY>
```

Take a look on file `terraform/terraform.tfvars` to setup terraform variables.
```
AWS_PUBLIC_SUBNET = ""
AWS_DEFAULT_VPC = ""
AWS_DEFAULT_AMI = ""
AWS_DEFAULT_REGION = ""
AWS_DEFAULT_INSTANCE_TYPE = ""
AWS_KEY_PAIR_NAME = ""
```
