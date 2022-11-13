FROM openjdk:8u151-jre-slim
MAINTAINER loyosteve@gmail.com
COPY arquitectura-monitor-server.jar /opt/arquitectura-monitor-server.jar
EXPOSE 8090
ENTRYPOINT ["java", "-Djava.awt.headless=true", "-jar", "/opt/arquitectura-monitor-server.jar"]
