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

### Import Jenkins Job
Read the process to import here: https://stackoverflow.com/questions/8424228/export-import-jobs-in-jenkins

The files to import are available on folder `jenkins/jobs`.
