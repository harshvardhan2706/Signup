FROM tomcat:9-jdk21
COPY signup.war /usr/local/tomcat/webapps/ROOT.war
