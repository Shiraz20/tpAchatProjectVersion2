FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/*.jar tpAchatProject-1.0.jar
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.jar"]
