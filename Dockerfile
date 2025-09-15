# Use an OpenJDK base image that supports Java 23.
# This ensures consistency between your development and container environments.
FROM openjdk:23-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from your target/ directory into the container.
# Make sure to replace 'your-application-name.jar' with the actual
# name of your Spring Boot JAR file.
COPY target/your-application-name.jar /app/app.jar

# Expose the port your application will run on. Spring Boot's default is 8080.
EXPOSE 8080

# Define the command to run your Spring Boot application when the container starts.
CMD ["java", "-jar", "app.jar"]