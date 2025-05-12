#!/bin/bash

# Build the application
echo "Building the application..."
./gradlew clean build

# Build the Docker image
echo "Building the Docker image..."
docker build -t product-tree-application .

# Start the services using docker-compose
echo "Starting the services with docker-compose..."
docker-compose up --build