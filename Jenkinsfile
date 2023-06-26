node {
    def mvnHome = tool 'maven-3.9.2'
    def dockerImage
    def dockerImageTag = "devopsexample${env.BUILD_NUMBER}"
    
    stage('Clone Repo') {
      git 'https://github.com/rhmanou/Jenkins-Test.git'
    }    
  
   
node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'maven-3.9.2';
    withSonarQubeEnv() {
      sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=testoutsidegit -Dsonar.projectName='testoutsidegit'"
    }
  }
}
	
    
   
}
