node('linux')
{
   
  stage ('Poll') {
                checkout([
                        $class: 'GitSCM',
                        branches: [[name: '*/main']],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [],
                        userRemoteConfigs: [[url: "https://github.com/zopencommunity/findutilsport.git"]]])
        }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/findutilsport.git'), string(name: 'PORT_DESCRIPTION', value: 'The GNU Find Utilities are the basic directory searching utilities of the GNU operating system.' )]
  }
}
