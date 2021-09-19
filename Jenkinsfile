pipeline {
  agent any
  tools { 
        maven 'Maven 3.3.9' 
    }
  stages{
    stage('preflight') {
      
      steps {
        
        sh "mvn clean install"
      }
    }
  }
 
}
