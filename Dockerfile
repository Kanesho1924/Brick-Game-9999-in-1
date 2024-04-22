FROM maven:3.6.3-openjdk-8-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package

FROM adoptopenjdk:8-jdk-hotspot
WORKDIR /app
COPY --from=build /app/target/brick-game-0.3.0-SNAPSHOT.jar .
CMD ["java", "-jar", "brick-game-0.3.0-SNAPSHOT.jar"]