FROM openjdk:21-jdk-alpine

WORKDIR /pay

COPY build/libs/pay-0.0.1-SNAPSHOT.jar /pay/pay-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/pay/pay-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
