FROM eclipse-temurin:21-jdk
MAINTAINER elnur
COPY build/libs/test-0.0.1-SNAPSHOT.jar rpo.jar
ENTRYPOINT ["java", "-jar", "rpo.jar"]

