FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/tpAchatProject-1.2.jar tpAchatProject-1.2.jar
ENTRYPOINT ["java","-jar","/tpAchatProject-1.2.jar"]
