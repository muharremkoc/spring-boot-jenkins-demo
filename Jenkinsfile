pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
         stage('Build') {
               steps {
                 sh """
                    mvn compile jib:dockerBuild
                    mvn clean package
                     """
               }
            }
         }
}
