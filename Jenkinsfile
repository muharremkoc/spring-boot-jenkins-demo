pipeline {
    agent any


    stages {
        stage("build project") {
            steps {
                  git 'https://github.com/muharremkoc/spring-boot-jenkins-demo.git'
                echo "JAVA_HOME"
                sh 'java -version'
                echo "MAVEN_HOME"
                sh  "./mvnw clean install -DskipTests"
                echo 'building project...'
                sh "./mvnw compile"
                sh "./mvnw package"
                //sh "mvn test"
                sh "mvn clean install"
            }
        }
    }
}
