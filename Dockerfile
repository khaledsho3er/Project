FROM openjdk:19

WORKDIR /app

copy . /app

RUN ./mvnw clean package

ENTRYPOINT ["java","-jar","/app/target/demo-0.0.1-SNAPSHOT.jar"]


# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar project.jar
