def call(){
    pipeline {
        agent any
        stages {
            stage('Build') {
                steps {
                    sh 'pip install -r requirements.txt'
                }
            }
            
            stage('Lint') {
                steps {
                    sh 'pylint-fail-under --fail_under 5.0 *.py'
                }
            }
            
            stage('Coverage Test') {
                steps {
                    script {
                        def files = findFiles (glob: 'test*.py')
                        for (file in files) {
                            sh "coverage run --omit */dist-packages/*,*/site-packages/* ${file}" 
                        }
                        sh 'coverage report'
                    }
                }
            }
            
            stage('Zip') {
                steps {
                    sh 'zip -r app.zip *.py'
                    archiveArtifacts artifacts: 'app.zip'
                }
                
            }
            
            // stage('Unit Test') {
            //     steps {
            //         sh 'python3 test_point_manager.py'
            //     }
            //     post {
            //         always {
            //             junit 'test-reports/*.xml'
            //         }
            //     }
            // }
            
            // stage('Integration Test') {
            //     steps {
            //         sh 'python3 test_points_api.py'
            //     }
            //     post{
            //         always {
            //             junit 'api-test-reports/*.xml'
            //         }
            //     }
            // }
        }
    }
}
    