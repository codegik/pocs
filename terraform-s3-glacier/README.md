# Terraform S3 Glacier

This is a POC to learn how to change storage class of file.

## Requirements
- Terraform
- AWS Cli

## Setup

I've configured a profile for testing on aws called `personal-lab` that has my credentials, please you need to setup your credentials using AWS Cli.

### Provisioning S3 bucket

```shell
terraform init
terraform plan
terraform apply
```

### Uploading file to S3

```shell
S3_NAME=$(terraform output -raw bucket-name)
aws s3 cp README.md "s3://$S3_NAME" --profile personal-lab
```

**WARNING:** before moving to Glacier, please understand that will take **3-5 hours** to restore file, and **aws might charge** this operation.

See read "Requests & data retrievals" section to understand the S3 pricing https://aws.amazon.com/s3/pricing/.

### Moving file to Storage Class Glacier

```shell
aws s3 cp "s3://$S3_NAME/README.md" "s3://$S3_NAME/README.md" --storage-class GLACIER --profile personal-lab
```

### Download file from S3 (first try)

Trying to download the file will fail because we need restore the file first.

```shell
aws s3 cp "s3://$S3_NAME/README.md" /tmp/ --profile personal-lab
```

### Restoring file from Glacier

Requesting to restore file from class glacier to standard, this will take **3-5 hours** to aws restore.

```shell
aws s3api restore-object --bucket $S3_NAME --key README.md --restore-request '{"Days":25,"GlacierJobParameters":{"Tier":"Standard"}}' --profile personal-lab
```

### Download file from S3 (second try)

3-5 hours later, then we're able to download the file again.

```shell
aws s3 cp "s3://$S3_NAME/README.md" /tmp/ --profile personal-lab
```

### Destroy provisioned resources

```shell
terraform destroy
```