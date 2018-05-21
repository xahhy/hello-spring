FROM openjdk:8-jdk-alpine

WORKDIR /

ARG JAR_FILE=./build/libs/hello-spring-latest.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT java -jar /app.jar
