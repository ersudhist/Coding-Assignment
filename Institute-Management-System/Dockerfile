# Stage 1: Build the Java application with Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /ims
COPY . ./
RUN mvn clean package -DskipTests

# Stage 2: Create a lightweight Java runtime image
FROM openjdk:17.0.1-jdk-slim
WORKDIR /ims
COPY --from=build /app/target/InstituteManagementSystem-0.0.1-SNAPSHOT.jar InstituteManagementSystem.jar
EXPOSE 8080
CMD ["java", "-jar", "InstituteManagementSystem.jar"]