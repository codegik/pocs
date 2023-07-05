# Pulumi

## Setup environment

```
brew install pulumi/tap/pulumi

# setup aws credentials first

```

## Setup project

```
mkdir java-project && cd java-project

sdk use java 17.0.3.6.1-amzn

pulumi new aws-java

pulumi config set aws:profile personal-lab

pulumi config set aws:region us-east-1


```

## Running and testing

```
pulumi up

pulumi stack output bucketName

aws s3 ls $(pulumi stack output bucketName) --profile personal-lab

curl $(pulumi stack output bucketEndpoint)

pulumi destroy

pulumi stack rm dev

```

## Notes

- Pulumi persist all data in its own platform by default.
- Command `pulumi destroy` deletes cloud infrastructure, but doen't delete persisted data in the plaftorm. It must run `pulumi stack rm dev` to delete from platform.
