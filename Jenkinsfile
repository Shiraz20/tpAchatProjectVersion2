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
                git branch: 'Devops-Produit' ,
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

        stage ('Maven SonarQube') {
            steps { 
               withSonarQubeEnv('sq1') {
               sh 'mvn sonar:sonar -Dsonar.login=b8f81399db39910c4a8481c9ba93188f7a5386cb'
                                         }
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
        stage("PUBLISH TO NEXUS") {
            steps {  
                sh 'mvn deploy'
            }
                }
        
    

        }
        /*

        stage('Connection to Nexus') {

          steps {

            sh "sudo docker login -u ${NEXUS_USERNAME} -p ${NEXUS_PASSWORD} ${DOCKER_REGISTRY}"

            }

          }

        stage('Push jar to maven repo'){

            steps{

                sh'mvn clean deploy -DskipTests'

            }

        } 

        stage('Build Docker image') {

          steps {

            //sh "sudo docker build -t ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG} ."

            sh "sudo docker build -t ${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG} ."

          }

        }

        stage('Push Docker image to Nexus') {

          steps {

            sh "sudo docker push ${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}" 

            }

          }

        stage('Get Docker image from Nexus') {

          steps {

            sh "sudo docker pull ${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}" 

            }

        }*/



        




        /*

        

        stage("SRC Analysis Testing") {

            steps {

                bat "mvn sonar:sonar"

            }

        }

        

        stage("Build Docker image") {

            steps {

                sh "..............."

            }

        }



        stage("Deploy Artifact to private registry") {

            steps {

                sh "..............."

            }

        }



        stage("Deploy Dokcer Image to private registry") {

            steps {

                sh "..............."

            }

        }*/ 

    

    post {

        success {

            emailext body: "The pipeline has completed successfully",

                attachLog: true,

                subject: "Jenkins pipeline completed successfully",

                to: "sarah.khabthani@esprit.tn"

        }

        failure {

            emailext body: "The pipeline has failed",

                attachLog: true,

                subject: "Jenkins pipeline failed",

                to: "sarah.khabthani@esprit.tn"

        }

        /*always {

            cleanWs()

        }*/

    }
}

    


