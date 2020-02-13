FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY build/libs/*.war jagdi.war
ENTRYPOINT ["java","-jar","/jagdi.war"]
