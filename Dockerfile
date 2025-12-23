FROM eclipse-temurin:21

WORKDIR /app

COPY target/desafio-itau-0.0.1-SNAPSHOT.jar .


EXPOSE 8080


CMD ["java", "-jar", "desafio-itau-0.0.1-SNAPSHOT.jar"]

