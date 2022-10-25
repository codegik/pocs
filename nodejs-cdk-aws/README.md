# CDK TypeScript POC
Provisioning AWS resources throught aws-cdk.

## Requirements
Make sure you have NodeJS installed.
Make sure you have an account on aws.
Make sure your aws credentials are properly configured.

## Perform provisioning
### Installing dependencies
```
npm install -g aws-cdk
npm install
cdk --version
```

### Create .env file to configure AWS account and region
```
AWS_ACCOUNT_NUMBER=your_aws_account_here
AWS_ACCOUNT_REGION=us-west-2
```

### Compare deployed stack with current state
```
cdk diff
```

### Deploy the AWS resources
```
cdk deploy
```

### Destroy the AWS resources
```
cdk destroy
```
