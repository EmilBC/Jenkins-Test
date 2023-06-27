node {
    def mvnHome = tool 'maven-3.9.2'
    def dockerImage
    def dockerImageTag = "devopsexample${env.BUILD_NUMBER}"
    
    stage('Clone Repo') {
      git 'https://github.com/EmilBC/Jenkins-Test.git'
    }


  
    stage('Build Project') {
      sh "'${mvnHome}/bin/mvn' -B -DskipTests clean package"
    }
    
    stage('Initialize Docker'){         
	  def dockerHome = tool 'MyDocker'         
	  env.PATH = "${dockerHome}/bin:${env.PATH}"     
    }
    
    stage('Build Docker Image') {
      sh "docker -H tcp://4.tcp.eu.ngrok.io:13971 build -t devopsexample:${env.BUILD_NUMBER} ."
    }
    
    stage('Deploy Docker Image'){
      	echo "Docker Image Tag Name: ${dockerImageTag}"
	sh "docker -H tcp://4.tcp.eu.ngrok.io:13971 run --name devopsexample -d -p 2222:2222 devopsexample:${env.BUILD_NUMBER}"
    }
}



