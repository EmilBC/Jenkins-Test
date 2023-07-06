def gv_script
pipeline{
    agent any

    stages{
        stage('Init'){
             echo "1."
            steps{
                script{
                    gv_script = load "script.groovy"
                }
            }
        }

        stage('Build'){
              echo "2."
            steps{
                script{
                    gv_script.buildApp()
                }
            }
        }

        stage('Test'){
            steps{
                script{
                    gv_script.testApp()
                }
            }
        }

        stage('Push image'){
            steps{
                script{
                    gv_script.pushImage()
                }
            }
        }

        stage('Deploy'){
            steps{
                script{
                    gv_script.deployApp()
                }
            }
        }

        stage('Commit'){
            steps{
                script{
                    gv_script.commitChanges()
                }
            }
        }
    }
    post{
        success{
            sh 'echo "Pipeline created successfully!"'
        }
    }
}
