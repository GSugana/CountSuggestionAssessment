# Spring Boot Gradle Project for County Suggestion

Based on Input names and Partial input names, the api will return the county suggestion

## Setup
1. Download the project in your machine
2. Navigate to the project directory
3. Build the project 
`./gradlew build`
4. Run it in local
`./gradlew bootRun`
5. Once the application is running, you can access it using a web browser or tools like cURL. By default, the application will be accessible at `http://localhost:3000`.
6. By hitting `http://localhost:3000/list` we will get the list of preloaded json data which we are storing in H2 in-memory database.

##Testing
1. Run tests with `./gradlew test`
