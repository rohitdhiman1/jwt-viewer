# Use official Eclipse Temurin Java 17 runtime
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy the built jar from target directory
COPY target/*.jar app.jar

EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "app.jar"]
