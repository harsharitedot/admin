# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the built application JAR file into the container
COPY target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
