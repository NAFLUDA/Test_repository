pipeline {
    agent any
    environment {
        dokerImage = ''
        registry = 'nafluda/pythonapp'
        registryCredencial = 'aa93560d-b255-423e-a012-b8d31c9ab8af'
    }

    stages {
        stage('Checkout') {
            steps {
               echo 'Luda Checkout'
               checkout([$class: 'GitSCM', branches: [[name: '*/Python']], extensions: [], userRemoteConfigs: [[credentialsId: 'f9e6b84d-2d59-44ff-9ccf-b1d16bc98954', url: 'https://github.com/NAFLUDA/Test_repository.git']]])
            }
        }
        stage('Test') {
            steps {
                echo 'Luda Test'
                git branch: 'python', credentialsId: 'f9e6b84d-2d59-44ff-9ccf-b1d16bc98954', url: 'https://github.com/NAFLUDA/Test_repository.git'
                bat 'python L_python.py'
            }
        }
        stage('Build Docker image') {
            steps {
                 script {
                    dockerImage = docker.build registry
                 }
            }
        }
        stage('Uploading Docker image') {
            steps {
                 script {
                    docker.withRegistry ( '', registryCredencial ) {
                    dockerImage.push()
                    }
                 }
            }
        }
        
    }
}
