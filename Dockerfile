FROM openjdk:latest

COPY target/bikers-backend-docker.jar bikers-backend-docker.jar
EXPOSE 8080
CMD ["java", "-jar", "bikers-backend-docker.jar"]