pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Branch Strategy') {
            steps {
                script {

                    if (env.BRANCH_NAME == 'main') {
                        echo "MAIN branch → Full build + tests + Docker"
                        sh 'mvn -B clean package'
                        sh 'docker build -t calculator:main -f docker/Dockerfile .'

                    } else if (env.BRANCH_NAME.startsWith('feature/')) {
                        echo "FEATURE branch → Build + tests only"
                        sh 'mvn -B clean test'

                    } else if (env.BRANCH_NAME.startsWith('release/')) {
                        echo "RELEASE branch → Build without tests"
                        sh 'mvn -B clean package -DskipTests'

                    } else {
                        echo "Other branch → No action"
                    }
                }
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
