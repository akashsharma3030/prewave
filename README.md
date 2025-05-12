# Prewave Product Tree Application

## Application Description
The **Prewave Product Tree Application** is a Spring Boot-based service designed to manage and query hierarchical relationships between nodes in a tree structure. It provides APIs to fetch node details and their relationships using recursive SQL queries. The application is built with a focus on scalability, maintainability, and ease of use.

## Features
- Recursive querying of hierarchical data using SQL.
- RESTful APIs for fetching node details.
- Exception handling for invalid or missing data.
- Dockerized for easy deployment.
- Built with Kotlin and Spring Boot for modern, efficient development.

## Tech Stack
- **Programming Language**: Kotlin
- **Framework**: Spring Boot
- **Database**: PostgreSQL (or any SQL database supported by JOOQ)
- **Build Tool**: Gradle
- **ORM**: JOOQ
- **Containerization**: Docker
- **API Documentation**: Swagger

## API Documentation
The application provides Swagger-based API documentation. Once the application is running, you can access the Swagger UI at:
http://localhost:8085/swagger-ui/index.html

## How to Run the Application

### Running via `run-docker.sh`
The application includes a `run-docker.sh` script to simplify running the application in a Docker container. Follow these steps:

1. **Ensure Docker is Installed**:
   Make sure Docker is installed and running on your system.

2. **Run the Script**:
   Execute the `run-docker.sh` script:
   ```bash
   ./run-docker.sh
   
### Running locally
  1. Setup Postgress database and run the script init.node_table.sql to create Node table in Postgres
  2. Modify application.properties for database connection details
  3. Run the kotlin class ProductTreeApplication 