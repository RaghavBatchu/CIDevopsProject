pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Strategy') {
            steps {
                script {

                    if (env.BRANCH_NAME == 'main') {
                        echo "MAIN branch → Build + Test + Docker"
                        sh 'mvn -B clean package'
                        sh 'docker build -t calculator:main -f docker/Dockerfile .'

                    } else if (env.BRANCH_NAME.startsWith('feature/')) {
                        echo "FEATURE branch → Build + Test"
                        sh 'mvn -B clean test'

                    } else if (env.BRANCH_NAME.startsWith('release/')) {
                        echo "RELEASE branch → Build only (skip tests & Docker)"
                        sh 'mvn -B -DskipTests clean package'
                    }
                }
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true,
                  testResults: '**/target/surefire-reports/*.xml'
        }
    }
}
