pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        post{
            always{
                emailext body: 'Summary', subject: 'Test result', to: 'arjunganesan12@gmail.com'
            }
        }
    }
}
