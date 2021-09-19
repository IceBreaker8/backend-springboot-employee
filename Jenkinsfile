pipeline {
  agent any
  stages {
    stage('Clean & Test') {
      steps {
        sh 'mvn clean'
      }
    }

    stage('Maven Install') {
      steps {
        sh 'mvn install -DskipTests'
      }
    }

    stage('Archive Jar') {
      steps {
        archiveArtifacts(artifacts: 'target/*.jar', fingerprint: true)
      }
    }

    stage('Deploy To EC2') {
      steps {
       
        sh 'aws s3 cp ./target/demo-0.0.1-SNAPSHOT.jar s3://elasticbeanstalk-eu-west-2-091256785188/demo-0.0.1-SNAPSHOT.jar'
        sh 'aws elasticbeanstalk create-application-version --application-name employeeManager3.0 --version-label 3.0 --source-bundle S3Bucket=elasticbeanstalk-eu-west-2-091256785188,S3Key=demo-0.0.1-SNAPSHOT.jar'
        sh 'aws elasticbeanstalk update-environment --application-name employeeManager3.0 --environment-name Employeemanager30-env --version-label 3.0'
      }
    }

  }
  tools {
    maven 'MAVEN'
    jdk 'JDK'
  }
}
