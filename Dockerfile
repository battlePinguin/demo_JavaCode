FROM eclipse-temurin:17-jdk as build
COPY . .
RUN sed -i 's/\r$//' gradlew
RUN chmod +x gradlew
RUN ./gradlew clean build -x test

FROM eclipse-temurin:17-jre-alpine
COPY --from=build build/libs/*.jar demo_javacode.jar
ENTRYPOINT ["java", "-jar", "demo_javacode.jar"]