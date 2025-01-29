#!/bin/sh

set -e
log_prefix="[test]"

echo "$log_prefix ------------------"
echo "$log_prefix Creating resources"
echo "$log_prefix ------------------"
echo ""
terraform plan
terraform apply --auto-approve

echo ""
echo "$log_prefix --------------------"
echo "$log_prefix Getting function URI"
uri=$(terraform output -raw function_uri)
echo "$log_prefix --------------------"

echo ""
echo "$log_prefix ---------------------------------------------------------------------"
echo "$log_prefix Calling function $uri"
echo "$log_prefix ---------------------------------------------------------------------"
curl "$uri"

echo ""
echo ""
echo "$log_prefix---------------------"
echo "$log_prefix Destroying resources"
echo "$log_prefix---------------------"
terraform destroy --auto-approve

echo ""
echo ""
echo "$log_prefix --------------------------"
echo "$log_prefix Test finished successfully"
echo "$log_prefix --------------------------"
