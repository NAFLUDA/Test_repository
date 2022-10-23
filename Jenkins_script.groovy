pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
               echo 'Luda Checkout'
               checkout([$class: 'GitSCM', branches: [[name: '*/Python']], extensions: [], userRemoteConfigs: [[credentialsId: 'f9e6b84d-2d59-44ff-9ccf-b1d16bc98954', url: 'https://github.com/NAFLUDA/Test_repository.git']]])
            }
        }
        stage('Build') {
            steps {
                echo 'Luda Build'
                git branch: 'python', credentialsId: 'f9e6b84d-2d59-44ff-9ccf-b1d16bc98954', url: 'https://github.com/NAFLUDA/Test_repository.git'
                bat 'python L_python.py'
            }
        }
        stage('Test') {
            steps {
            echo 'Luda test'
            }
        }
        
    }
}
