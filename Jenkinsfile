pipeline {
  agent any
  tools{maven 'maven 3'}
  stages {
    stage ('Build') {
      sh 'mvn clean install'
    }

  }
}
