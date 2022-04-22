pipeline {
    // agent { docker { image 'maven:3.8.4-openjdk-11-slim' } }
    agent any
    stages {
        stage('build') {
            steps {
                sh 'echo "Starting pipeline"'
                sh 'mvn --version'
                sh 'mvn clean'
                sh 'mnv package'
            }
        }
    }
}
