FROM eclipse-temurin:17-jre
WORKDIR /usr/src/app

COPY eco-auth/target/*.jar app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "eco-auth-1.0.0.jar"]
