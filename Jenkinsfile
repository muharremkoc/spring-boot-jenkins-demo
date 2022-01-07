pipeline {
  environment {
    registry = "mhrrmdockerhub/spring-boot-jenkins"
    registryCredential = 'dockerhub_id'
    dockerImage = ''
  }
  agent any
  stages {
    stage('Cloning our Git') {
      steps {
        git 'https://github.com/muharremkoc/spring-boot-jenkins-demo.git'
      }
    }
    stage('Building our image') {
      steps {
        script {
          dockerImage = docker.build registry + ":latest"
        }
      }
    }
    stage('Deploy our image') {
      steps {
        script {
          docker.withRegistry('', registryCredential) {
            dockerImage.push()
          }
        }
      }
    }
  }