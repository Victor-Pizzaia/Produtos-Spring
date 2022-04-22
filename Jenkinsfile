pipeline {
    // agent { docker { image 'maven:3.8.4-openjdk-11-slim' } }
    agent any
    stages {
        stage('build') {
            steps {
                bat 'echo "Starting pipeline"'
                bat 'mvn --version'
                bat 'mvn clean'
                bat 'mnv package'
            }
        }
    }
}
