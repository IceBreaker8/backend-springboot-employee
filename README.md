# backend-springboot-employee

## Deployment AWS

Elastic Beanstalk & RDS

## Target artifacts

Located in the `target/*.jar` directory.

## Deploy to Elastic Beanstalk

1) Install AWS CLI in the Virtual Machine
2) Upload file to S3 using aws beanstalk CLI
3) archive jar using the pipeline
4) aws elasticbeans upload and deploy using aws beanstalk CLI

create new `aws elasticbeanstalk create-application-version --application-name <name> --version-label <version> --source-bundle S3Bucket=<bucket>,S3Key=<artifact>`

