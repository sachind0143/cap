pipeline {

    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {

	stage('Checkout Code') {
    		steps {
        		git branch: 'main', url: 'https://github.com/sachind0143/cap.git'
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

        stage('Publish Report') {
            steps {
                publishHTML(target: [
                    reportDir: 'test-output',
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Automation Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
                ])
            }
        }
    }
}