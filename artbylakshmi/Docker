# Use an official Maven image to build and run the application
FROM maven:3.8.6-openjdk-17-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and download the dependencies (this allows us to cache dependencies)
COPY pom.xml .

# Download the project dependencies
RUN mvn dependency:go-offline

# Copy the entire project into the container
COPY . .

# Build the application (without packaging it, just to make sure everything is set up)
RUN mvn clean install -DskipTests

# Use OpenJDK 17 runtime to run the Spring Boot application
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the entire project into the container
COPY --from=build /app /app

# Expose the application port (default Spring Boot port)
EXPOSE 8080

# Command to run the application using Maven
CMD ["mvn", "spring-boot:run", "-Dspring-boot.run.profiles=prod"]
