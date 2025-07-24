FROM tomcat:9-jdk17
COPY signup.war /usr/local/tomcat/webapps/ROOT.war
# Note: The base image has been updated to use JDK 17 for compatibility with the latest features.