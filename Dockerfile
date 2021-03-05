FROM centos
RUN yum install -y java
RUN yum install -y sqlite
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]