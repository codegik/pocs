# GCP + Terraform + Functions

## Requirements
- gcloud
- terraform

## Configure
```
brew install terraform
brew install --cask google-cloud-sdk
gcloud init
```

## Deploy function
```
gcloud functions deploy hello-node-function \
  --gen2 \
  --runtime=nodejs22 \
  --region=us-central1 \
  --source=./app \
  --entry-point=hello \
  --trigger-http \
  --allow-unauthenticated
```
