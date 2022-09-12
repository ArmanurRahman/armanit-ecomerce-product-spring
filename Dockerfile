FROM openjdk:11-slim as build
MAINTAINER armanit.net

COPY target/product-0.0.1-SNAPSHOT.jar product-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/product-0.0.1-SNAPSHOT.jar"]