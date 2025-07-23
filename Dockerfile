FROM tomcat:9-jdk17
COPY signup.war /usr/local/tomcat/webapps/ROOT.war
