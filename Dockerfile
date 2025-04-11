FROM eclipse-temurin:21-jdk-alpine


WORKDIR /app

# Copia apenas os arquivos de build já prontos
COPY ./ ./

RUN ./gradlew build -x test

EXPOSE 8080

CMD ["java", "-jar", "./build/quarkus-app/quarkus-run.jar"]
