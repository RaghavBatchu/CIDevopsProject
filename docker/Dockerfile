# --- Builder stage ---
FROM maven:3.9.6-eclipse-temurin-11 AS builder
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests package

# --- Runtime stage ---
FROM eclipse-temurin:11-jre-jammy
WORKDIR /app
COPY --from=builder /build/target/calculator-1.0.jar /app/calculator.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/calculator.jar"]
