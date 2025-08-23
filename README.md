# JWT Viewer

A simple Java Spring Boot web application to decode and view JWT tokens, inspired by [jwt.io](https://jwt.io).

## Features
- Paste a JWT token and select whether it is signed or unsigned
- View the decoded header and payload in color-highlighted JSON
- No need for a secret key to view the payload
- Works with both signed and unsigned JWTs


## How to Run Locally

1. Make sure you have Java 17+ and Maven installed.
2. In the project directory, run:
   ```sh
   mvn spring-boot:run
   ```
3. Open your browser and go to [http://localhost:8080](http://localhost:8080)

## How to Deploy on Render (Free Cloud Hosting)

1. Build your app locally (optional):
   ```sh
   mvn clean package
   ```
2. Make sure your code is pushed to GitHub and includes the `Dockerfile` in the project root:
   ```dockerfile
   # Use official Eclipse Temurin Java 17 runtime as builder
   FROM eclipse-temurin:17-jdk as builder
   WORKDIR /app
   COPY . .
   RUN apt-get update && apt-get install -y maven
   RUN mvn clean package
   FROM eclipse-temurin:17-jre
   WORKDIR /app
   COPY --from=builder /app/target/*.jar app.jar
   EXPOSE 8080
   CMD ["java", "-jar", "app.jar"]
   ```
3. Go to [Render](https://render.com/) and sign up/login.
4. Click "New Web Service" and connect your GitHub repo.
5. Select **Docker** as the environment and set Dockerfile path to `Dockerfile`.
6. Click "Create Web Service" and wait for deployment.
7. Your app will be live at the public URL provided by Render.

## Usage

1. Paste your JWT token in the left panel.
2. Select "Signed" or "Unsigned".
3. Click "Decode".
4. The decoded header and payload will appear on the right in a color-highlighted JSON format.

### Example Tokens

**Signed JWT (HS256):**

```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
```

**Unsigned JWT (alg: none):**

```
eyJhbGciOiJub25lIiwidHlwIjoiSldUIn0.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0
```

**Payload Example:**

```json
{
  "sub": "1234567890",
  "name": "John Doe",
  "admin": true,
  "iat": 1516239022
}
```

---

This project uses Spring Boot, Thymeleaf, and JJWT.