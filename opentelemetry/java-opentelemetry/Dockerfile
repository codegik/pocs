FROM alpine/java:21-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY ./agent/opentelemetry-javaagent.jar opentelemetry-javaagent.jar
ENTRYPOINT ["java", "-javaagent:/opentelemetry-javaagent.jar", "-Dotel.service.name=java-opentelemetry", "-Dotel.traces.exporter=zipkin", "-Dotel.javaagent.debug=OTEL_JAVAAGENT_DEBUG", "-jar", "/app.jar"]