FROM openjdk:8-jdk-alpine
COPY target/back-0.0.1-SNAPSHOT.jar back-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/back-0.0.1-SNAPSHOT.jar"]