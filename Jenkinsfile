pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        sh './auto/test'
      }
    }
    stage('Release') {
      when {branch 'master'}
      steps {
        sh './auto/release'
      }
    }
    stage('Staging') {
      when {branch 'master'}
      environment {
        PORT = '81'
        APP_ENV = 'staging'
      }
      steps {
        sh './auto/deploy'
      }
    }
    stage('Production') {
      when {branch 'master'}
      environment {
        APP_ENV = 'prod'
        PORT = '80'
      }
      steps {
        input 'Deploy?'
        sh './auto/deploy'
      }
    }
  }
}
