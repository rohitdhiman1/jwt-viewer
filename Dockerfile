# Use official Eclipse Temurin Java 17 runtime as builder
FROM eclipse-temurin:17-jdk as builder

WORKDIR /app
COPY . .

# Install Maven
RUN apt-get update && apt-get install -y maven

RUN mvn clean package

# Use a smaller JRE image for running the app
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]