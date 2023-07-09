FROM openjdk:18-jdk-alpine
MAINTAINER ishita.sharma
COPY build/libs/table-reservation-0.0.1-SNAPSHOT.jar table-reservation-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/table-reservation-0.0.1-SNAPSHOT.jar"]