pipeline {
    agent any
    environment {
        IMAGE_REGISTRY = '  mhrrmdockerhub/spring-boot-jenkins'
        IMAGE_VERSION = 'latest'
        IMAGE_REGISTRY_CREDENTIAL = 'dockerhub_id'
        DOCKER_REGISTRY_URL = ""
    }
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
          sh  "mvn clean compile jib: build"
        }
      }

      stage('Docker Publish') {
        steps {
          withDockerRegistry([credentialsId: "${IMAGE_REGISTRY_CREDENTIAL}", url: "https://hub.docker.com/u/mhrrmdockerhub"]) {
            sh "docker push ${IMAGE_REGISTRY}:${IMAGE_VERSION}"
          }
        }
      }

      stage('Deploy Docker-compose') {
        steps {
          sh "docker-compose -f /home/jenkins/docker-compose.yml stop "
          withDockerRegistry([credentialsId: "${IMAGE_REGISTRY_CREDENTIAL}", url: "https://hub.docker.com/u/mhrrmdockerhub"]) {
            sh "docker-compose -f /home/jenkins/docker-compose.yml pull"
          }
          dir('/home/jenkins') {
            sh "docker-compose up -d"
          }
        }
      }
    }
}