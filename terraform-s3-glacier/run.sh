#!/bin/sh

PROFILE="--profile personal-lab"
cd infra

terraform init
terraform plan
terraform apply -auto-approve

S3_NAME=$(terraform output -raw bucket-name)

# uploading file to S3
aws s3 cp ../README.md "s3://$S3_NAME" $PROFILE

# WARNING: before moving to Glacier, please understand that will take 3-5 hours to restore file, and aws might charge this operation.
# See read "Requests & data retrievals" section to understand the S3 pricing https://aws.amazon.com/s3/pricing/.
# moving file to Glacier
aws s3 cp "s3://$S3_NAME/README.md" "s3://$S3_NAME/README.md" --storage-class GLACIER --profile personal-lab

# trying to download the file will fail because we need restore the file
aws s3 cp "s3://$S3_NAME/README.md" /tmp/ --profile personal-lab

# requesting to restore file from glacier to s3, this will take 3-5 hours to aws restore.
aws s3api restore-object --bucket $S3_NAME --key README.md --restore-request '{"Days":25,"GlacierJobParameters":{"Tier":"Standard"}}' $PROFILE

# 3-5 hours later, then we're able to download the file again
aws s3 cp "s3://$S3_NAME/README.md" /tmp/ --profile personal-lab

terraform destroy -auto-approve

cd -

exit 0