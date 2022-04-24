FROM adoptopenjdk/openjdk11:alpine-jre
LABEL maintainer="angelestrada14019"
ADD target/project-hospital-spring-0.0.1-SNAPSHOT.jar app.jar
VOLUME /main-app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

