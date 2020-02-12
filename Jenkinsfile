pipeline {
    agent any 
    stages {
        stage('Git Clone') { 
            steps {
                 echo 'Cloning...'
                 bat ' git clone https://github.com/pagadalajagadeesh/springbootWithInterceptor.git'
            }
        }
        stage('Gradle Build') { 
            steps {
                  echo 'Gradle Building...'
                  bat 'cd ..'
                  bat 'gradlew build -x test' 
            }
        }
        stage('Docker Build') { 
            steps {
                  echo 'Docker Building...'
                  bat 'docker build -t  pagadalajagadeesh/springboot .'
            }
        }
        
   
   		stage('Deploy Spring Boot Application') {
          steps {
        		 echo 'Docker Building...'
                 bat 'docker container run -p 8080:8080 -d pagadalajagadeesh/springboot'
          }
   		}
    }
}
