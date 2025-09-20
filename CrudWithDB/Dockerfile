# Use official Tomcat 10.1 image with JDK 21
FROM tomcat:10.1-jdk21

# Remove default ROOT app
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy your WAR into webapps
COPY target/myapp.war /usr/local/tomcat/webapps/ROOT.war

# Copy PostgreSQL JDBC driver to Tomcat lib
COPY postgresql-42.6.0.jar /usr/local/tomcat/lib/

# Expose port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
