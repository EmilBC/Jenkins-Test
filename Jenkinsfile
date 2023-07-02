
pipeline {
	
    agent any
	environment {
   mvnHome = tool 'maven-3.9.2'
}
    parameters {
        booleanParam(name: "BUILD_FOR_PRODUCTION", defaultValue: false, description: "Check if it's for prod")
	     choice(name: "BUILD_LANGUAGE", choices: ["JAVA", "NET", "PHP"], defaultValue:"JAVA" ,description: "Choose your techno, for dev please set default value in your commited file")
        string(name: "TEST_STRING", defaultValue: "ssbostan", trim: true, description: "Sample string parameter")
        text(name: "TEST_TEXT", defaultValue: "Jenkins Pipeline Tutorial", description: "Sample multi-line text parameter")
        password(name: "TEST_PASSWORD", defaultValue: "root", description: "Sample password parameter")
        choice(name: "TEST_CHOICE", choices: ["production", "staging", "development"], description: "Sample multi-choice parameter")
 	
    }
    stages {
        stage("Build Prod") {
		when {
                expression { 
                   return params.BUILD_FOR_PRODUCTION == true
                }
            }
            steps {
		
		git 'https://github.com/EmilBC/Jenkins-Test.git'
                echo "Build stage Prod."
               
		sh "'${mvnHome}/bin/mvn' -B -DskipTests clean package"
		
		
            }
	}
	      stage("Build Prod Dev") {
	when {
                expression { 
                  return params.BUILD_FOR_PRODUCTION == false
                }
            }
		 steps {
		
		git 'https://github.com/EmilBC/Jenkins-Test.git'
                echo "Build stage Dev"
               
		sh "'${mvnHome}/bin/mvn' -B -DskipTests clean package"
		
            }
        }
    
	    stage('Deploying React.js container to Kubernetes') {
      steps {
        script {
          kubernetesDeploy(configs: "deployment.yaml", "service.yaml")
        }
      }
    }
        stage("Test") {
            steps {
                echo "Test stage."
            }
        }
        stage("Release") {
		when {
                expression { 
                   return params.TEST_TEXT == 'Jenkins Pipeline Tutorial'
                }
            }
            steps {
                echo "Release stage."
            }
        }
    }
}



//pipeline {
 
    //def mvnHome = tool 'maven-3.9.2'
    //def dockerImage
    //def dockerImageTag = "devopsexamplenew${env.BUILD_NUMBER}"

	
   
    
    //stage('Clone Repo') {
      //git 'https://github.com/EmilBC/Jenkins-Test.git'
    //}

    //stage('SCM') {
	//  checkout scm
    //}
    //stage('SonarQube Analysis') {
     // def mvn = tool 'maven-3.9.2';
      //withSonarQubeEnv() {
      //sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=testoutsidegit -Dsonar.projectName='testoutsidegit'"
      //}
    //}	
  
    //stage('Build Project') {
     // sh "'${mvnHome}/bin/mvn' -B -DskipTests clean package"
    //}
    
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
//}
