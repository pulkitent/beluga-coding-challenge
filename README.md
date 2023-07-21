# String Service

This service purpose is to do manipulations on string

### Pre-requisites (for running the service)

* [Docker](https://docs.docker.com/compose/install/)

### Run using Docker

1. Run `docker build --tag=string-service:latest .` to build Docker image
2. Run `docker run -p 8080:8080 string-service:latest` to run the service
3. Example CURL to reverse a given
   string `curl --location 'curl --location 'http://localhost:8080/apis/v1/strings/reverse' \
   --header 'Content-Type: application/json' \
   --data '{"input": "Beluga"}''`

### IntelliJ Setup

1. Add lombok plugin (Preferences > Plugins > Search for Lombok)
2. Enable annotation processing (Preferences > Build, Execution, Deployment > Compiler > Annotation Processors)

### Setting up your local environment for development

1. Install [Docker](https://www.docker.com/community-edition)
2. Install Java 17
3. Install Gradle 8 (or any other version a gradle wrapper will take care)
4. Run `./gradlew clean test` to run the unit tests
5. Run `./gradlew clean build` to build the service
6. Run `./gradlew clean bootRun` to start service
7. Run `./gradlew clean bootJar` to create fat JAR