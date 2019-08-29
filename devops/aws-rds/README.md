# Postgres RDS provision

## Requirements
To run this provision it is necessary has those tools:
- docker

You shold have an account on aws and do upload off your public key.

## Perform provisioning
### Build local Jenkins
```
cd jenkins
docker build . -t jenkins-terraform
```

### Start local Jenkins
```
docker run -it -p 8080:8080 -p 50000:50000 jenkins-terraform
```
Follow de wizard process to setup the Jenkins plugins.

### Create Jobs
The Jenkinsfile are are available on folder `jenkins`, you can create a pipeline job referencing those files.

### Create Jenkins Credentials
Create the following Jenkins credentials:
- AWS_ACCESS_KEY (your aws access key)
- AWS_SECRET_KEY (your aws secret key)
