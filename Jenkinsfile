pipeline {
  agent any
  stages {
    stage('Clean') {
      steps {
        sh 'mvn clean'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }

    stage('Maven Install') {
      steps {
        sh 'mvn install'
      }
    }

  }
  tools {
    maven 'MAVEN'
    jdk 'JDK'
  }
}