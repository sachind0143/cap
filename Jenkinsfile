pipeline {

    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/sachind0143/CapstoneProject.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {

            junit 'target/surefire-reports/*.xml'

            publishHTML(target: [
                reportDir: 'test-output',
                reportFiles: 'ExtentReport.html',
                reportName: 'Automation Report',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])
            archiveArtifacts artifacts:'test-output/**',fingerprint:true
        }
    }
}