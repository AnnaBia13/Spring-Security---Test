#Etapa de construção
#FROM maven:latest-openjdk-21 AS build
#FROM ubuntu:latest AS build

FROM openjdk:21-jdk-slim AS build

# Instale o barato do Maven
RUN apt-get update && apt-get install -y maven && apt-get clean && rm -rf /var/lib/apt/lists/*

# Definir o diretório dentro do container para a aplicação
WORKDIR /app

#Copiar o pom.xml para o container
COPY pom.xml .
COPY src ./src

#Executar o Maven para compilar projeto e gerar o JAR File
RUN mvn clean package -DskipTests

#Estapa de execução
FROM openjdk:21-slim

#Definir o diretório de trabalho para aplicação
WORKDIR /app

#Copiar o JAR construído na etapa anterior
COPY --from=build /app/target/*.jar app.jar

#Definir a Porta que será utilizada na aplicação.
EXPOSE 8080

#Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]