pipeline {
    agent any
    stages {
        stage('Hello') {
            steps {
                echo "Hello world"
                    }
            }
        }
    post{
        always{
            mail to: "emil.bou-chebel@docaposte.fr",
            subject: "Test Email",
            body: "Test"
        }
    }
}
