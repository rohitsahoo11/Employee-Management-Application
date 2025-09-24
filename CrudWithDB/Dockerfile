# Step 1: Use Tomcat base image
FROM tomcat:10.1-jdk21

# Remove default ROOT app
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy WAR (make sure you export it from Eclipse first)
COPY myapp.war /usr/local/tomcat/webapps/ROOT.war

# If you need PostgreSQL driver, copy it too (optional)
COPY lib/postgresql-42.7.8.jar /usr/local/tomcat/lib/

# Expose port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
