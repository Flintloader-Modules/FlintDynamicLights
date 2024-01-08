def projectName = "Ryoamiclights";
def projectIcon = "https://media.forgecdn.net/avatars/878/132/638304530972741181.png";

pipeline {
    agent {
        label "master"
    }
    tools {
        jdk "JAVA17"
    }

    stages {
        stage("Notify Discord") {
            steps {
                discordSend webhookURL: env.SSS_WEBHOOK,
                        title: "Deploy Started: ${projectName} 1.20.4 Deploy #${BUILD_NUMBER}",
                        link: env.BUILD_URL,
                        result: 'SUCCESS',
                        description: "Build: [${BUILD_NUMBER}](${env.BUILD_URL})"
            }
        }

        stage("Prepare") {
            steps {
                sh "chmod +x ./gradlew"
                sh "./gradlew clean"
            }
        }

        stage("Build") {
            steps {
                sh "./gradlew build"
            }
        }
    }

    post {
        always {
            sh "./gradlew --stop"
            archiveArtifacts artifacts: 'build/libs/*.jar'

            fddsnapshotter apiKey: env.PLATFORM_KEY,
                projectSlug: "ryoamiclights",
                projectName: "${projectName}",
                projectIcon: "${projectIcon}",
                versionName: "0.0.${BUILD_NUMBER}",
                version: "0.0.${BUILD_NUMBER}",
                modLoaders: "flint",
                minecraftVersions: "1.20.4",
                failWebhook: env.SSS_WEBHOOK,
                publishWebhooks: "${env.SSS_WEBHOOK}|${env.SNAPSHOTS_WEBHOOK}"

            deleteDir()
        }
    }
}