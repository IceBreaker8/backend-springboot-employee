# backend-springboot-employee

## Deployment AWS

EC2 & RDS

## Target artifacts

Located in the `target/*.jar` directory.

## Deploy to Elastic Beanstalk

1) Install AWS CLI
2) Upload file to S3
3) archive jar using the pipeline
4) aws elasticbeans upload and deploy

create new `aws elasticbeanstalk create-application-version --application-name <name> --version-label <version> --source-bundle S3Bucket=<bucket>,S3Key=<artifact>`

