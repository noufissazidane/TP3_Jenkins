pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean package'
            }
        }
    }

    post {
        always {

            junit '**/target/surefire-reports/*.xml'

            jacoco()
        }
        success {
            echo 'Super ! Le build a réussi.'
        }
        failure {
            echo 'Oh non... Le build a échoué.'
        }
    }
}