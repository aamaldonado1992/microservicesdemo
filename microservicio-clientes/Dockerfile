# Etapa 1: Construir el proyecto
FROM maven:3.8.8-eclipse-temurin-17 AS builder
WORKDIR /app

# Copia los archivos del proyecto
COPY pom.xml .
COPY src ./src

# Compila y empaqueta el proyecto
RUN mvn clean package -DskipTests

# Etapa 2: Crear la imagen final
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia el archivo JAR desde la etapa de compilación
COPY --from=builder /app/target/microservicio-clientes-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto
EXPOSE 8081

# Comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
