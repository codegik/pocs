# GCP + Terraform + MySQL + Functions

This POC is about using functions to persist data into MySQL.

## Requirements
- NodeJS 16 (nvm install 16)
- Terraform 1.5.7 (brew install terraform)
- Google Cloud Sdk (brew install --cask google-cloud-sdk)

## Configure
```
gcloud init
gcloud auth login
export GOOGLE_APPLICATION_CREDENTIALS="$HOME/.config/gcloud/legacy_credentials/<your-user-email>/adc.json"
terraform init
```

## Deploy function
```
terraform plan
terraform apply
```

In the output, you'll see the function URL.

## Test function
```
curl <function-url>
```

## Delete all resources
```
teraform destroy
```

## Run automated test
This will create GCP resources, and then request the function and then destroy GCP resources.

```
export GCP_PROJECT_ID=<your-gcp-project-id>
./test.sh
```