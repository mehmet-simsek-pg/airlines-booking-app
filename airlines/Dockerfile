FROM openjdk:18 AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:18
WORKDIR airlinesDev
COPY --from=build target/*.jar airlinesSystem.jar
ENTRYPOINT ["java", "-jar", "airlinesSystem.jar"]