node {
    def mvnHome = tool 'maven-3.9.2'
    def dockerImage
    def dockerImageTag = "devopsexample${env.BUILD_NUMBER}"
    
    stage('Clone Repo') {
      git 'https://github.com/rhmanou/Jenkins-Test.git'
    }    
  
    stage('Build Project') {
      sh "'${mvnHome}/bin/mvn' -B -DskipTests clean package"
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
	
    
    stage('Initialize Docker'){         
	  def dockerHome = tool 'MyDocker'         
	  env.PATH = "${dockerHome}/bin:${env.PATH}"     
    }
    
    stage('Build Docker Image') {
      sh "docker -H tcp://192.168.8.100:2375 build -t devopsexample:${env.BUILD_NUMBER} ."
    }
    
    stage('Deploy Docker Image'){
      	echo "Docker Image Tag Name: ${dockerImageTag}"
	sh "docker -H tcp://192.168.8.100:2375 run --name devopsexample -d -p 2222:2222 devopsexample:${env.BUILD_NUMBER}"
    }
}
