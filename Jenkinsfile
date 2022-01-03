pipeline {
    agent any


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
                    mvn clean package
                     """
               }
            }
    }
}
