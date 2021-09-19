pipeline {
  agent any
  tools{MAVEN 'maven 3'}
  stages {
    stage ('Build') {
      sh 'mvn clean install'
    }

  }
}
