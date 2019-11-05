pipeline {
    agent any

    tools {
        jdk 'jdk-12'
        maven 'maven'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install test-compile'
            }
        }
        stage('api') {
            steps {
                sh 'mvn clean test -pl :api'
            }
        }
        stage('service') {
                    steps {
                        sh 'mvn clean test -pl :service'
                    }
        }
        stage('domain') {
            steps {
                sh 'mvn clean test -pl :domain'
            }
        }
        stage('infrastructure') {
            steps {
                sh 'mvn clean test -pl :infrastructure'
            }
        }
        
    }
}