def call(ip,user,credID){
sshagent([credID]) {
    sh "mv target/*.war target/nirupa.war"
    // copy war
    sh "scp -o StrictHostKeyChecking=no target/nirupa.war ${user}@${ip}:/opt/tomcat9/webapps"
    // stop war
    sh "ssh ${user}@${ip} /opt/tomcat9/bin/shutdown.sh"
    // start war
    sh "ssh ${user}@${ip} /opt/tomcat9/bin/startup.sh"
   }
}
