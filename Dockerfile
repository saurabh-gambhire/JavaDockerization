FROM openjdk:17

COPY target/dockerization-0.0.1-SNAPSHOT.jar app-dockerization.jar

ENTRYPOINT ["java", "-jar", "app-dockerization.jar"]