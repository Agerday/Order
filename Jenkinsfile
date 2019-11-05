pipeline {
    agent any

    tools {
        jdk 'jdk-12'
        maven 'maven'
    }

    stages {
        stage('Build') {
            steps {
                sh 'JAVA_HOME=/var/jenkins_home/jdk-12/ mvn clean install test-compile'
            }
        }
        stage('api') {
            steps {
                sh 'JAVA_HOME=/var/jenkins_home/jdk-12/ mvn clean test -pl :api'
            }
        }
        stage('service') {
                    steps {
                        sh 'JAVA_HOME=/var/jenkins_home/jdk-12/ mvn clean test -pl :service'
                    }
        }
        stage('domain') {
            steps {
                sh 'JAVA_HOME=/var/jenkins_home/jdk-12/ mvn clean test -pl :domain'
            }
        }
        stage('infrastructure') {
            steps {
                sh 'JAVA_HOME=/var/jenkins_home/jdk-12/ mvn clean test -pl :infrastructure'
            }
        }
        
    }
}