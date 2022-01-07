/*
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
                    withDockerRegistry([credentialsId: "${IMAGE_REGISTRY_CREDENTIAL}", url: "https://hub.docker.com/repository/docker/mhrrmdockerhub"]) {
                        sh "docker push ${IMAGE_REGISTRY}:${IMAGE_VERSION}"
                    }
            }
        }
    }
}
 */
pipeline {
  environment {
    registry = "https://hub.docker.com/r/mhrrmdockerhub/spring-boot-jenkins"
    registryCredential = 'dockerhub_id'
    IMAGE_VERSION = 'latest'
    dockerImage = ''
  }
  agent any
  stages {
    stage('Cloning our Git') {
      steps {
        git 'https://github.com/muharremkoc/spring-boot-jenkins-demo.git'
      }
    }
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
                    withDockerRegistry([credentialsId: "${registryCredential}", url: "https://hub.docker.com/repository/docker/mhrrmdockerhub"]) {
                        sh "docker push ${registry}:${IMAGE_VERSION}"
                    }
            }
        }
  }
}
