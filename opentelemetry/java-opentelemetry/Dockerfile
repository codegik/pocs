FROM alpine/java:21-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY ./agent/opentelemetry-javaagent.jar opentelemetry-javaagent.jar
#ENV OTEL_EXPORTER_OTLP_ENDPOINT=http://host.docker.internal:4318
ENV OTEL_EXPORTER_OTLP_ENDPOINT=http://10.40.80.48:4318
ENTRYPOINT ["java", "-javaagent:/opentelemetry-javaagent.jar", "-jar", "/app.jar"]