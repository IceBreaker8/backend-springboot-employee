pipeline {
  agent any
  stages{
    stage('preflight') {
      steps {
        withMaven(maven: 'MAVEN') {
        sh 'mvn clean install'
         }
      }
    }
  }
 
}
