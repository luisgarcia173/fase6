FROM openjdk

WORKDIR /app

COPY build/libs/fase6-0.0.1-SNAPSHOT.jar /app/fase6.jar

ENTRYPOINT ["java", "-jar", "fase6.jar"]