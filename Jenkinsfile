pipeline {
  agent any
  environment {
    IMAGE_REGISTRY = 'mhrrmdockerhub/spring-boot-jenkins'
    IMAGE_VERSION = 'latest'
    IMAGE_REGISTRY_CREDENTIAL = 'dockerhub_id'
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
        sh "docker login -u mhrrmdockerhub -p muho145358."
        sh "docker push mhrrmdockerhub/spring-boot-jenkins:latest"
      }
    }

    stage('Deploy Docker-compose') {
      steps {
        sh "docker login -u mhrrmdockerhub -p muho145358."
        sh "docker-compose -f /home/jenkins/docker-compose.yml stop"
        sh "docker-compose -f /home/jenkins/docker-compose.yml pull "
        dir('/home/jenkins') {
          sh "docker-compose up -d"
        }
      }
    }
  }
}