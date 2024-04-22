pipeline {
    agent any

    tools {  
        maven 'Maven'
        jdk 'Java' 
    }

    environment {
        
        MAVEN_HOME = "${tool 'Maven'}"
        JAVA_HOME = "${tool 'Java'}"
    }

    stages {
        stage('Récupération Github') {
            steps {
                git 'https://github.com/Kanesho1924/Brick-Game-9999-in-1.git'
            }
        }

        stage('Tests + Package') {
            steps {
                script {
                    if (isUnix()) {
                        sh "${MAVEN_HOME}/bin/mvn -DskipTests clean package"
                    } else {
                        bat "${MAVEN_HOME}\\bin\\mvn -DskipTests clean package"
                    }
                }
            }
            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }

        stage('Notification') {
            steps {
                echo "Préparation à l'envoi des notifications..."
            }
            post {
                success {
                    mail to: 'avande764@gmail.com',
                         subject: "SUCCÉS: Build #${env.BUILD_NUMBER}",
                         body: "Le build a réussi. Veuillez regarder les détails dans ${env.BUILD_URL}"
                }
                failure {
                    mail to: 'avande764@gmail.com',
                         subject: "ÉCHEC: Build #${env.BUILD_NUMBER}",
                         body: "Le build a échoué. Veuillez vérifier vos logs Jenkins"
                }
            }
        }
    }
}
