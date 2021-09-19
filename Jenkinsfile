pipeline {
  agent any
  tools { 
        maven 'MAVEN' 
    }
  stages{
    stage('preflight') {
      
      steps {
        
        sh "mvn clean install"
      }
    }
  }
 
}
