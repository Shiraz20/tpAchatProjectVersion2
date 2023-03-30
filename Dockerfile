FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/tpAchatProject-1.3.jar tpAchatProject-1.3.jar
ENTRYPOINT ["java","-jar","/tpAchatProject-1.3.jar"]
