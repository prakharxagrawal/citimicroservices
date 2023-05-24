pipeline {
    agent any
    
    stages {
	
	stage('compile')
	{
	   steps{
		   echo 'installing npm dependencies'
	       sh '''cd UI/eldorado
		   npm install'''	
	    }
	}
	
	stage('test')
	{
		steps{
			sh '''
			cd UI/eldorado 
			npm run test
			'''
		}
	}

	stage('Sonarqube')
	{
		steps{
			dir('UI/eldorado'){
				withSonarQubeEnv('sonarqube') {
				sh "npm run sonar"
				}
			}
		}
	}
	
	stage('package') {
		steps {
			sh '''cd UI/eldorado 
				npm run build'''	
		}
	}
	
	}
}