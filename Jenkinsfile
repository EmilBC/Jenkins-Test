pipeline {
 
    def mvnHome = tool 'maven-3.9.2'
    def dockerImage
    def dockerImageTag = "devopsexamplenew${env.BUILD_NUMBER}"

	
   
    
    stage('Clone Repo') {
      git 'https://github.com/EmilBC/Jenkins-Test.git'
    }

    stage('SCM') {
	  checkout scm
    }
    stage('SonarQube Analysis') {
      def mvn = tool 'maven-3.9.2';
      withSonarQubeEnv() {
      sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=testoutsidegit -Dsonar.projectName='testoutsidegit'"
      }
    }	
  
    stage('Build Project') {
      sh "'${mvnHome}/bin/mvn' -B -DskipTests clean package"
    }
    
   // stage('Initialize Docker'){         
	//  def dockerHome = tool 'MyDocker'         
	  //env.PATH = "${dockerHome}/bin:${env.PATH}"     
    //}
    
   // stage('Build Docker Image') {
     // sh "docker -H tcp://6.tcp.eu.ngrok.io:17444 build -t devopsexamplenew:${env.BUILD_NUMBER} ."
    //}
    
    //stage('Deploy Docker Image'){
      //	echo "Docker Image Tag Name: ${dockerImageTag}"
	//sh "docker -H tcp://6.tcp.eu.ngrok.io:17444 run --name devopsexamplenew -d -p 2222:2222 devopsexamplenew:${env.BUILD_NUMBER}"
    //}
}
