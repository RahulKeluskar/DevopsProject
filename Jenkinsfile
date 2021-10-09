pipeline {
    agent any
    stages {
        stage('Build and test selenium project')
        agent { //here we select only docker build agents
            docker {
                image 'maven:latest' //container will start from this image
            }
        }
        steps {
          dir('selenium-tests/GridSetupTest'){
              sh 'mvn clean install' //this command will be executed inside maven container
          }
        }

    }  
    post {
        always {
            step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
        }
      }
}
