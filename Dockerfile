#Etapa de construção
#FROM maven:3.4.3-openjdk-21 AS build
FROM ubuntu:latest AS build
#FROM openjdk:21-jdk-slim AS build
#RUN apt-get update && apt-get-install -y maven && apt-get clean && rm -rf/var/lib/apt/lists/*
RUN apt-get update
RUN apt-get install openjdk-21-jdk -y

#Definir o diretório dentro do container para a aplicação
#WORKDIR /app

#Copiar o pom.xml para o container
#COPY pom.xml .
#COPY src ./src

COPY . . 

#Executar o Maven para compilar projeto e gerar o JAR File
RUN mvn clean package -DskipTests

#Etapa de execução
FROM openjdk:21-jdk-slim

#Definir o diretório de trabalho para a aplicação
#WORKDIR /app

#Definir a Porta que será utilizada na aplicação
EXPOSE 8080

#Copiar o JAR construído na etapa anterior
COPY --from=target /target/rest-service.jar app.jar


#Comando para executar a aplicação
ENTRYPOINT [ "java", "-jar", app.jar ]