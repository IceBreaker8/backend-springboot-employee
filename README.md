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

create new `aws elasticbeanstalk create-application-version --application-name employeeManager3.0 --version-label * --source-bundle S3Bucket=elasticbeanstalk-eu-west-2-091256785188,S3Key=demo-0.0.1-SNAPSHOT.jar`

