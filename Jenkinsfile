pipeline {
  agent any  
    stages {
        stage('clean') { 
            steps {
                sh 'mvn clean '
            }
        }
        stage('validate') { 
            steps {
                sh 'mvn validate'
            }
        }
       stage('compile') { 
            steps {
                sh 'mvn compile'
            }
        }
        stage('test') { 
            steps {
                sh 'mvn test -DskipTests'
            }
        }
        stage('package') { 
            steps {
                sh 'mvn package -DskipTests'
            }
        }
        stage('verify') { 
            steps {
                sh 'mvn verify -DskipTests'
            }
        }
        stage('install') { 
            steps {
               sh 'mvn install -DskipTests'
            }
        }
        stage('Deploy') { 
            steps {
                
                sh 'mvn deploy -DskipTests'
            }
        }
        stage('release') { 
            steps {
                sh 'mvn release -DskipTests -DskipTests'
            }
        }
    }
}
