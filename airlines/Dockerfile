FROM openjdk:18 AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:18
WORKDIR airlines-booking-app
COPY --from=build target/*.jar airlines-booking-app.jar
ENTRYPOINT ["java", "-jar", "airlines-booking-app.jar"]