pipeline {
    agent any 
    stages {
        stage('Git Clone') { 
            steps {
                 echo 'Cloning...'
                  git 'https://github.com/pagadalajagadeesh/springbootWithInterceptor.git'
            }
        }
        stage('Gradle Build') { 
            steps {
                  echo 'Gradle Building...'
                  bat 'gradlew build -x test' 
                 echo "You can also use \${BUILD_NUMBER} -> ${BUILD_NUMBER}"
                  bat "move build\\libs\\sbInterceptor-0.0.1-SNAPSHOT.war build\\libs\\"sbInterceptor-"+${BUILD_NUMBER}.war"
            }
        }
        stage('Docker Build') { 
            steps {
                  echo 'Docker Building...'
                  bat 'docker build -t  pagadalajagadeesh/springboot .'
            }
        }
         stage('Docker removing old container ') { 
            steps {
                  echo 'removing old container...'
               script {
                try{
                  bat 'docker container stop springboot'
                  bat 'docker rm -v springboot'
                } catch(Exception e){
                  echo 'Exception occurred while removing old container...'
                }
            }
            }
        }
   
   		stage('Deploy Spring Boot Application') {
          steps {
        		 echo 'Docker Building...'
            //     bat 'docker container run -p 8081:8081 -d --name springboot pagadalajagadeesh/springboot'
               bat 'docker container run --publish 8080:8080 --detach --name springboot pagadalajagadeesh/springboot'
          }
   		}
    }
}
