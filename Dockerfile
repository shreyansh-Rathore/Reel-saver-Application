# ---- Build Stage (Java 25 + Maven) ----
FROM maven:3.9-eclipse-temurin-25 AS build
COPY . .
RUN mvn clean package -DskipTests

# ---- Runtime Stage (Java 25 JRE) ----
FROM eclipse-temurin:25-jre
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
