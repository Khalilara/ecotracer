FROM eclipse-temurin:17-jre
WORKDIR /usr/src/app

COPY eco-core/target/*.jar app.jar

EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
