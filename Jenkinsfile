pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        sh './auto/test'
      }
    }
    stage('Release') {
      when {branch 'production'}
      steps {
        sh './auto/release'
      }
    }
    stage('Staging') {
      when {branch 'production'}
      environment {
        PORT = '81'
        APP_ENV = 'staging'
      }
      steps {
        sh './auto/deploy'
      }
    }
    stage('Production') {
      when {branch 'production'}
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
