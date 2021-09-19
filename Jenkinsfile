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
        sh 'eb deploy'
      }
    }

  }
  tools {
    maven 'MAVEN'
    jdk 'JDK'
  }
}