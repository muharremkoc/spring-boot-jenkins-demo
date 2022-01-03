pipeline {
    agent any

    stages {
        stage("build project") {
            steps {
                  git 'https://github.com/muharremkoc/spring-boot-jenkins-demo.git'
                echo "JAVA_HOME"
                sh 'java -version'
                echo "MAVEN_HOME"
                sh 'mvn -version'
                echo 'building project...'
                sh "mvn compile"
                sh "mvn package"
                //sh "mvn test"
                sh "mvn clean install"
            }
        }
    }
}