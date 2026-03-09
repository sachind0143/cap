pipeline {

    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/username/flight-automation-framework.git'
            }
        }

        stage('Build Project') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML([
                    reportDir: 'test-output',
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Automation Report'
                ])
            }
        }
    }
}