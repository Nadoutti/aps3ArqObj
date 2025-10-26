FROM amazoncorretto:21

COPY target/aps3-0.0.1-SNAPSHOT.jar.original /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
