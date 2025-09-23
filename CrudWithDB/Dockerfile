# Step 1: Build WAR using Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Set working directory
WORKDIR /app

# Copy source code
COPY . .

# Run Maven to build the WAR file
RUN mvn clean package -DskipTests

# Step 2: Use Tomcat to run the WAR
FROM tomcat:10.1-jdk21

# Remove default ROOT app
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy WAR built in first stage
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# (Optional) Copy PostgreSQL JDBC driver into Tomcat lib if needed
# COPY lib/postgresql-42.7.8.jar /usr/local/tomcat/lib/

# Expose port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
