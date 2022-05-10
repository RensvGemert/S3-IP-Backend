FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:latest
COPY target/bikers-backend-docker.jar /usr/local/lib/bikers-backend-docker.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/bikers-backend-docker.jar"]