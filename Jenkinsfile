pipeline {
  agent any
  tools{MAVEN}
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
