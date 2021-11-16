pipeline {
    agent {
        label 'docker'
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvnw -B -DskipTests clean package' 
            }
        }
    }
}