# 1) Build stage: usamos Maven para compilar y empaquetar
FROM maven:3.8.8-eclipse-temurin-17 AS builder
WORKDIR /app

# 1.a) Copiamos solo pom.xml para aprovechar cache de dependencias
COPY pom.xml ./

# 1.b) Descargamos dependencias (capa cacheable)
RUN mvn dependency:go-offline -B

# 1.c) Copiamos el código fuente y empaquetamos
COPY src ./src
RUN mvn clean package -DskipTests -B

# 2) Runtime stage: ejecutamos el JAR resultante
FROM eclipse-temurin:17-jdk-slim
WORKDIR /app

# 2.a) Copiamos el JAR desde la etapa builder
COPY --from=builder /app/target/*.jar app.jar

# 2.b) Documentamos el puerto en que corremos (no obliga al contenedor)
EXPOSE 8080

# 2.c) Arrancamos usando la variable PORT (Render la inyecta)
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dserver.port=${PORT:-8080} -jar app.jar"]
