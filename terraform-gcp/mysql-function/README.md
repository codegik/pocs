# GCP + Terraform + MySQL + Functions

This POC is about using functions to persist data into MySQL.

[Link](https://medium.com/@williamwarley/a-complete-guide-to-gcp-serverless-with-terraform-29a3486094f2#id_token=eyJhbGciOiJSUzI1NiIsImtpZCI6ImZhMDcyZjc1Nzg0NjQyNjE1MDg3YzcxODJjMTAxMzQxZTE4ZjdhM2EiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiIyMTYyOTYwMzU4MzQtazFrNnFlMDYwczJ0cDJhMmphbTRsamRjbXMwMHN0dGcuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiIyMTYyOTYwMzU4MzQtazFrNnFlMDYwczJ0cDJhMmphbTRsamRjbXMwMHN0dGcuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMDM2NzMxMDY2NDUwNDU3MjQ5NjAiLCJlbWFpbCI6ImluYWNpb2tsYXNzbWFubkBnbWFpbC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwibmJmIjoxNzM4MTg5MDMzLCJuYW1lIjoiSW5hY2lvIEtsYXNzbWFubiIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vYS9BQ2c4b2NKcG5pQXl1NXg1SjhQUWRhYTlPREczeXFYZUJSaHNsYTJ0V1JYTUIweW0xVW10bDM3Uz1zOTYtYyIsImdpdmVuX25hbWUiOiJJbmFjaW8iLCJmYW1pbHlfbmFtZSI6IktsYXNzbWFubiIsImlhdCI6MTczODE4OTMzMywiZXhwIjoxNzM4MTkyOTMzLCJqdGkiOiJlMjlmNDAxNjFjYWE0OWExNDAyZDNhOTMxYTFhZjdjYWE0MmM0OGQ5In0.SiduhqsJe32o4EYmbQIocOK5dYV4fqy_JuTvcQpv1Cj8KiOS1dSmSt4-8rLqF8cLKwhx2fWTxcYvvE3HfclhDSP9cXTwXAuIdUXCL8Z2wcWXcAm8Ii3vJLsYERGFiHQrH3tAq5GzHyTNXzRMcfkUJ3wGH-pOlOpHp0z_sqknEGs_Wfl2VaDY7sFn6Lh3glHjalP49kIxXrqeeRG5ZFgUs3JzOU002WQwdzmoINRYTSTcLiZDGz0gQ-tC-xYiuvJDQ-0jUd14qtK8sbUdnHXF8UBJxQEGY8mMTiMvmvebq5bcFOCQGkPc0m8nbt3BXTaEidFa19TF1UtYzBncLsbPAA)

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