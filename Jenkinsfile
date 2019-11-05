pipeline {
    agent any

    tools {
        jdk 'jdk-12'
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean install test-compile'
            }
        }
        stage('war') {
            steps {
                bat 'mvn clean test -pl :war'
            }
        }
        stage('api') {
            steps {
                bat 'mvn clean test -pl :api'
            }
        }
        stage('service') {
                    steps {
                        bat 'mvn clean test -pl :service'
                    }
        }
        stage('domain') {
            steps {
                bat 'mvn clean test -pl :domain'
            }
        }
        stage('infrastructure') {
            steps {
                bat 'mvn clean test -pl :infrastructure'
            }
        }
        
    }
}
