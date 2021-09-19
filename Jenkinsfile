pipeline {
  agent any
  stages{
    stage('preflight') {
      steps {
        withMaven(maven: 'MAVEN', mavenSettingsConfig: 'MyGlobalSettings') {
        sh 'mvn clean install'
         }
      }
    }
  }
 
}
