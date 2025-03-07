# Use an official OpenJDK runtime as a base image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the JAR file from the target directory (Maven builds here)
COPY target/*.jar app.jar

# Expose the port (Spring Boot default is 8080)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
