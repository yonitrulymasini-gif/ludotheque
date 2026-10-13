FROM eclipse-temurin:21-jdk
WORKDIR /workspace
CMD ["sh", "./mvnw", "spring-boot:run"]