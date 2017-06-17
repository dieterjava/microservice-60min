pipeline {
    agent { docker 'java:openjdk-8' }
    stages {
        stage('build + tests') {
            environment {
                npm_config_cache = 'npm-cache'
            }
            steps {
                sh './gradlew test'
            }
        }
        stage('integ tests') {
            environment {
                npm_config_cache = 'npm-cache'
            }
            steps {
                sh './gradlew integrationTest'
            }
        }
        stage('sonarqube') {
            environment {
                npm_config_cache = 'npm-cache'
            }
            steps {
                withEnv(["SONARQUBE_SERVER_URL=${SONARQUBE_SERVER}"]) {
                    sh './gradlew -Dsonar.host.url=${SONARQUBE_SERVER_URL} sonarqube'
                }
            }
        }
    }
}