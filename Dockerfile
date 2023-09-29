FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/M3S07-0.0.1-SNAPSHOT.jar /app/M3S07.jar

EXPOSE 8080

CMD ["java", "-jar", "M3S07.jar"]
