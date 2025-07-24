FROM tomcat:9-jdk21
COPY signup.war /usr/local/tomcat/webapps/ROOT.war
# Note: The base image has been updated to use JDK 21 for compatibility with the latest features.