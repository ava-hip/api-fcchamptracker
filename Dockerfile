FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/api-fcchamptracker-0.0.1-SNAPSHOT.jar /app/my-api.jar

ENTRYPOINT ["java", "-jar", "my-api.jar"]

