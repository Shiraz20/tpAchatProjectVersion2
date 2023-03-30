FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/tpAchatProject-0.0.2-SNAPSHOTS.jar tpAchatProject-0.0.2-SNAPSHOTS.jar
ENTRYPOINT ["java","-jar","/tpAchatProject-0.0.2-SNAPSHOTS.jar"]
