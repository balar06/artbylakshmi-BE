# Use the official Maven image (latest) as the base
FROM maven:latest AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and download the dependencies (this allows us to cache dependencies)
COPY pom.xml .

# Download the project dependencies
RUN mvn dependency:go-offline

# Copy the entire project into the container
COPY . .

# Build the application and package it into a JAR file (without skipping tests)
RUN mvn clean package -DskipTests

# Use OpenJDK 17 runtime to run the Spring Boot application
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file from the build stage into the final image
COPY --from=build /app/target/*.jar app.jar

# Expose the application port (default Spring Boot port)
EXPOSE 8080

# Command to run the Spring Boot application using the JAR file
CMD ["java", "-jar", "app.jar"]
