#Etapa de construção
FROM maven:3.4.3-openjdk-21 AS build
#FROM ubuntu:latest AS build

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