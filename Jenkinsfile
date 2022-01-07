pipeline {
    agent any
    environment {
        IMAGE_REGISTRY = 'https://hub.docker.com/r/mhrrmdockerhub/spring-boot-jenkins'
        IMAGE_VERSION = 'latest'
        IMAGE_REGISTRY_CREDENTIAL = 'jenkinscreds'
        DOCKER_REGISTRY_URL = ""
    }
    stages {
        stage('Build') {
           agent {
             docker {
               image 'maven:3.8.1-adoptopenjdk-11'
               args '-v $HOME/.m2:/root/.m2'
               reuseNode true
             }
           }
           steps {
             sh """
                mvn compile jib:dockerBuild
                 """
           }
        }

        stage('Docker Publish') {
            steps {
                    withDockerRegistry([credentialsId: "${IMAGE_REGISTRY_CREDENTIAL}", url: "https://hub.docker.com/u/mhrrmdockerhub"]) {
                        sh "docker push ${IMAGE_REGISTRY}:${IMAGE_VERSION}"
                    }
            }
        }
    }
}
