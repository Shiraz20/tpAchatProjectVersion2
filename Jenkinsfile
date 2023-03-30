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
        
        stage('Cleaning up ') {
            steps {
                 sh "docker rmi $registry:$BUILD_NUMBER"
                
    }
}
        stage('docker compose') {
            steps {
                 sh "docker-compose up -d"
                
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
    }
     post {

        success {

            emailext body: "The pipeline has completed successfully",

                recipientProviders: [[$class: 'DevelopersRecipientProvider']],

                subject: "Jenkins pipeline completed successfully",

                to: "sarah.khabthani@esprit.tn"

        }

        failure {

            emailext body: "The pipeline has failed",
                recipientProviders: [[$class: 'DevelopersRecipientProvider']],
                subject: "Jenkins pipeline failed",
                to: "sarah.khabthani@esprit.tn"

        }

      

    }
}
