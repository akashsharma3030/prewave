# Stage 1: PostgreSQL setup
FROM postgres:15.3 as db-setup

# Set environment variables for PostgreSQL
ENV POSTGRES_DB=postgres
ENV POSTGRES_USER=testuser
ENV POSTGRES_PASSWORD=testpass

# Copy the SQL script to the container
COPY src/main/resources/init_node_table.sql /docker-entrypoint-initdb.d/

# Stage 2: Application setup
FROM openjdk:21-jdk-slim as app

# Set the working directory
WORKDIR /app

# Copy the application JAR file
COPY build/libs/producttree-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8085

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]