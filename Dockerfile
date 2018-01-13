FROM openjdk:8-jdk-alpine
ADD target/poc-ribbon-spring-load-balance-0.0.1-SNAPSHOT.jar poc-ribbon-consul.jar
RUN sh -c 'touch /poc-ribbon-consul.jar'
ENV JAVA_OPTS="-Xms256M -Xmx1024M -XX:+ExitOnOutOfMemoryError"
ENTRYPOINT ["java", "-jar", "poc-ribbon-consul.jar"]
