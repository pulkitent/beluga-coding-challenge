# String Service

This service purpose is to do manipulations on string

### Pre-requisites (for running the service)

* [Docker](https://docs.docker.com/compose/install/)

### Run using Docker

1. Run `docker build --tag=string-service:latest .` to build Docker image
2. Run `docker run -p 8080:8080 string-service:latest` to run the service
3. Example CURL to reverse a given
   string `curl --location 'http://localhost:8080/apis/v1/strings/reverse' \
   --header 'Content-Type: application/json' \
   --data '{
   "input": "Beluga"
   }'`

### API documentation (Swagger)

1. Start the service using above steps
2. Open http://localhost:8080/swagger-ui/index.html in your browser

### IntelliJ Setup

1. Add lombok plugin (Preferences > Plugins > Search for Lombok)
2. Enable annotation processing (Preferences > Build, Execution, Deployment > Compiler > Annotation Processors)

### Setting up your local environment for development

1. Install [Docker](https://www.docker.com/community-edition)
2. Install Java 17
3. Install Gradle 8 (or any other version a gradle wrapper will take care)
4. Run `./gradlew clean test` to run the unit tests
5. Run `./gradlew clean cucumberCli` to run the integration tests (Cucumber feature tests)
6. Run `./gradlew clean build` to build the service
7. Run `./gradlew clean bootRun` to start service
8. Run `./gradlew clean bootJar` to create fat JAR

## Thought process

As a supporter of evolutionary design which gets improved iteration by iteration on getting more clear requirements. I
have tried to implement this project in the same way. However, there could be different opinions which I am happy to
discuss & open to take as a feedback

## Things I have tried to cover

* I have tried to implement clean architecture having ports, adapters & use-cases (Although business logic was simple,
  hence one suggest to not go for this architecture in this case).
* I have tried to accommodate SOLID principles & 4 rules of simple design.
* I have tried to make logical & small commits.
* I have tried to Dockerized the application.
* I have tried to add independent unit tests in **"Given When Then"** format with 87% line coverage & with mocking
  wherever required & possible with its test report using JACOCO.
* I have tried to add SITs (Service Isolation Tests or Integration tests) in BBD format using Cucumber with test report
* I have added ci-cd.yml to set up CI CD pipeline in GitHub flow.
* I have tried to implement notification pattern as suggested by Martin Fowler by not throwing
  exceptions [ref-link](https://martinfowler.com/articles/replaceThrowWithNotification.html)
* I have tried to integrate Swagger documentation using springdoc openapi

## Things I could have covered if given more time (or more complex business logic)

* As a supporter of DDD I could have also added domain models in case of complex business logic as I prefer fat
  domain models
* I could have asserted response body in my integrations tests using Cucumber BDD
* I could have published docker image created to my personal Docker hub account in GitHub actions (CI CD pipeline)
