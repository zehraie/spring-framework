##Baseimage
FROM openjdk:11

COPY ./target/Spring-24-docker-0.0.1-SNAPSHOT.jar  /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java","-jar","Spring-24-docker-0.0.1-SNAPSHOT.jar"]
