pipeline {
  agent any
  stages{
    stage('preflight') {
      steps {
        withMaven(maven: 'MAVEN', mavenSettingsConfig: 'setting-xml') {
        sh 'mvn clean install'
         }
      }
    }
  }
 
}
