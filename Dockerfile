FROM openjdk:8
COPY target/*.jar phonevalidation.jar
COPY sample.db sample.db
ENTRYPOINT ["java","-jar","phonevalidation.jar"]