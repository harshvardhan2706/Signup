FROM tomcat:9-jdk22
COPY signup.war /usr/local/tomcat/webapps/ROOT.war
