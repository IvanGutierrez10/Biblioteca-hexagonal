FROM eclipse-temurin

COPY /build/libs/Biblioteca-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "Biblioteca-0.0.1-SNAPSHOT.jar"]

VOLUME /logs/