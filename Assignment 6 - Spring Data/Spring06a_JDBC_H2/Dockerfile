FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/Spring06a_JDBC_H2-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]