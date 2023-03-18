pipeline {

     environment {

        DOCKER_REGISTRY = '172.10.0.140:8083'
        DOCKER_IMAGE_NAME = 'sarahprojet'
        DOCKER_IMAGE_TAG = 'latest'

        NEXUS_REPOSITORY = 'my_repo'
        NEXUS_REPOSITORY_MAVEN = 'maven-releases'
        NEXUS_REPOSITORY_PATH = ''

        CONTAINER_NAME = 'devopsSarah'

        NEXUS_USERNAME = 'admin'
        NEXUS_PASSWORD = 'admin'

    }

    agent {

        label "agent"

    } 

    stages {

        stage("Build Project") {

            steps {

                sh "mvn clean package -DskipTests"

            }

        }/*

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

        stage('Down app'){

          steps{

            sh 'sudo docker-compose down'

          }

        }

        stage('Run app with compose'){

          steps{

            sh 'sudo docker-compose up -d'

          }

        }

        




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

    }

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