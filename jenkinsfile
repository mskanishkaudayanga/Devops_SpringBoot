pipeline {
    agent any
    tools {
        maven 'MavenInstall'
    }
    parameters {
        string(name: 'VERSION', defaultValue: '1.0.0', description: 'Version of the application')
    }
    stages {
        stage('Checkout and Build') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/mskanishkaudayanga/Devops_SpringBoot']])
                bat 'mvn clean install -DskipTests'
            }
        }
        stage('Build Docker image') {
            steps {
                script {
                    def version = params.VERSION
                    bat "docker build -t kanishka/devops_integration:${version} ."
                }
            }
        }
        stage('login docker hub') {
            steps {
                withCredentials([string(credentialsId: 'changeDockerpwd', variable: 'dockerpwd')]) {
                    bat 'docker login -u kanishkaudayanga -p %dockerpwd%'
                }
            }
        }
        stage('push docker hub') {
            steps {
                script {
                    def version = params.VERSION
                    // Corrected docker tag command
                    bat "docker tag kanishka/devops_integration:${version} kanishkaudayanga/devops_integration:${version}"
                    // Corrected docker push command
                    bat "docker push kanishkaudayanga/devops_integration:${version}"
                }
            }
        }
    }
}
