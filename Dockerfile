  
FROM openjdk:8-jdk-alpine
EXPOSE 1010
ADD target/VirtualKey.jar jenkins-integration-virtualkey.jar
ENTRYPOINT ["java","-jar","jenkins-integration-virtualkey.jar"]
