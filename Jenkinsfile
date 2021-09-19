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
        archiveArtifacts artifacts: 'C:\\Windows\\system32\\config\\systemprofile\\.m2\\repository\\com\\blog\\demo\\0.0.1-SNAPSHOT\\demo-0.0.1-SNAPSHOT.jar', followSymlinks: false
      }
    }

  }
  tools {
    maven 'MAVEN'
    jdk 'JDK'
  }
}
