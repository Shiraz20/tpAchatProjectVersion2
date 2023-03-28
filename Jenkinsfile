pipeline {
    environment { 
                }
    
    agent any
    
    stages {
                
        stage ('Maven Clean') {
            steps {
                sh 'mvn clean'
            }
        }

        stage ('Maven Compile') {
            steps {
                sh 'mvn compile'
                  }
        }
        
        stage ('Maven Package') {
            steps {
                sh 'mvn package'
                  }
        }
        
    }
}
