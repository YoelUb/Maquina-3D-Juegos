# 1) Build stage: compilar + preparar frontend
FROM maven:3.8.8-eclipse-temurin-17 AS builder
WORKDIR /app

# 1.a) Dependencias cacheables
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# 1.b) Código fuente y package en modo production
COPY src ./src
# -Pproduction activa el profile de Vaadin que genera flow-build-info.json
RUN mvn clean package -Pproduction -DskipTests -B

# 2) Runtime stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Documentación del puerto
EXPOSE 8080

# Arranque en ProductionMode y con el PORT dinámico
ENTRYPOINT ["sh","-c","java $JAVA_OPTS \
  -Dserver.port=${PORT:-8080} \
  -Dvaadin.productionMode=true \
  -jar app.jar"]
