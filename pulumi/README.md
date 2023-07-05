# Pulumi

## Setup

```
brew install pulumi/tap/pulumi

# setup aws credentials first

mkdir java-project && cd java-project

sdk use java 17.0.3.6.1-amzn

pulumi new aws-java

pulumi config set aws:profile personal-lab

pulumi config set aws:region us-east-1

pulumi up

pulumi stack output bucketName

aws s3 ls $(pulumi stack output bucketName) --profile personal-lab

curl $(pulumi stack output bucketEndpoint)

pulumi destroy

pulumi stack rm dev

```
