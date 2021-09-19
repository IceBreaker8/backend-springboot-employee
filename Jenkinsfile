pipeline {
  agent any
  stages{
    stage('preflight') {
      steps {
        def mvnHome = tool name: 'MAVEN', type: 'maven'
        sh "${mvnHome}/bin/mvn package"
      }
    }
  }
 
}
