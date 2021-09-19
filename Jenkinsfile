pipeline {
  agent any
  stages {
    stage('Build & Test') {
      steps {
        sh 'mvn clean install'
      }
    }

  }
  tools {
    maven 'MAVEN'
    jdk 'JDK'
  }
}