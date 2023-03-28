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
        
        stage ('Checkout git') {
            steps {
                git branch: 'Devops-Facture' ,
                url:'https://github.com/Shiraz20/tpAchatProjectVersion2.git'
                  }
              }
        
        stage ('Maven Clean') {
            steps {
                sh 'mvn clean install'
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
        
            stage ('Maven SonarQube') {
            steps { 
               withSonarQubeEnv('sq1') {
               sh 'mvn sonar:sonar -Dsonar.login=b8f81399db39910c4a8481c9ba93188f7a5386cb'
                                       }
                   }
         }
        
             stage("PUBLISH TO NEXUS") {
             steps {  
                sh 'mvn deploy'
                   }
          }
        
             stage('Building our image') { 
             steps { 
                script { 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
                        }
                    } 
           }
        
            stage('Deploy our image') { 
            steps { 
                script { 
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push() 
                        }
                        } 
                   }
            }
    
           stage("Docker-compose") {
                steps{
                    sh 'docker-compose up -d --force-recreate --build'
                     }
           }
        
    }
}
