FROM maven:3.9-eclipse-temurin-21 AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo pom.xml para descargar las dependencias de Maven
COPY pom.xml .

# descarga de dependencias de Maven para que estén disponibles en la compilación
RUN mvn dependency:go-offline -B

# Copia el código fuente de la aplicación al contenedor
COPY src ./src

# Maven ejecuta el procesamiento de anotaciones de Lombok durante la compilación.
RUN mvn clean package -DskipTests

# FASE 2

# Utiliza una imagen base más ligera para ejecutar la aplicación
FROM eclipse-temurin:21-jre

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado desde la fase de compilación al contenedor
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto en el que la aplicación escuchará
EXPOSE 8080

# Define el comando de entrada para ejecutar la aplicación Java
ENTRYPOINT ["java", "-jar", "app.jar"]
