pipeline {
  agent any
  stages{
    stage('preflight') {
      steps {
        withMaven(maven: 'MAVEN', mavenSettingsConfig: 'mvn-setting-xml') {
        sh "mvn clean install "
         }
      }
    }
  }
 
}
