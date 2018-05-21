pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        sh './auto/test'
      }
    }
    stage('Release') {
      steps {
        sh './auto/release'
      }
    }
    stage('Staging') {
      environment {
        PORT = '81'
        APP_ENV = 'staging'
      }
      steps {
        sh './auto/deploy'
      }
    }
    stage('Production') {
      environment {
        APP_ENV = 'production'
        PORT = '80'
      }
      steps {
        input 'Deploy?'
        sh './auto/deploy'
      }
    }
  }
}