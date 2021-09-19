pipeline {
  agent any
  tools { 
        maven 'MAVEN' 
        jdk 'JDK'
    }
  stages{
    stage('preflight') {
      
      steps {
        
        sh "mvn clean install"
      }
    }
  }
 
}
