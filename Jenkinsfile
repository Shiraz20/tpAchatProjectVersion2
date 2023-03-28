pipeline {
    environment { 
        registry = "sarahkhh/achat" 
        registryCredential = 'dockerhub' 
        dockerImage = ''
        
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCAOL = "http"
        NEXUS_URL = "172.10.0.140:8081"
        NEXUS_REPOSITORY = "nexus-repo-devops"
        NEXUS_CREDENTIAL_ID = "deploymentRepo"
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
