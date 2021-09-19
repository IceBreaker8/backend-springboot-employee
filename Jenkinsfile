pipeline {
  agent any
  stages{
    stage('preflight') {
      def mvnHome = tool name: 'MAVEN', type: 'maven'
      steps {
        
        sh "${mvnHome}/bin/mvn package"
      }
    }
  }
 
}
