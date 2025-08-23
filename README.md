# JWT Viewer

A simple Java Spring Boot web application to decode and view JWT tokens, inspired by [jwt.io](https://jwt.io).

## Features
- Paste a JWT token and select whether it is signed or unsigned
- View the decoded header and payload in color-highlighted JSON
- No need for a secret key to view the payload
- Works with both signed and unsigned JWTs

## How to Run

1. Make sure you have Java 17+ and Maven installed.
2. In the project directory, run:
   ```sh
   mvn spring-boot:run
   ```
3. Open your browser and go to [http://localhost:8080](http://localhost:8080)

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