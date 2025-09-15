# Use an OpenJDK base image with Java 21, which is a stable LTS release.
# This image is widely available on Docker Hub.
FROM openjdk:21-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/your-application-name.jar /app/app.jar

# Expose the port your application will run on
EXPOSE 8080

# Define the command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]