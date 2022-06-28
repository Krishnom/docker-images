podTemplate(yaml: """
kind: Pod
spec:
  containers:
  - name: did
    image: docker
    command:
    - cat
    tty: true
"""
  ) {

  node(POD_LABEL) {
    container('did') {
      stage('Build Docker image') {
          checkout([
            $class: 'GitSCM', 
            branches: [[name: '*/main']], 
            extensions: [], 
            userRemoteConfigs: [
              [
                credentialsId: 'bitbucket-cloudops-service-account', 
                url: 'https://bitbucket.org/experitestrnd/slo-status-dashboard.git'
              ]
            ]
          ])
          
        sh """
            docker build -t slo-status-app/v1 .
        """
      }
    }
  }
}