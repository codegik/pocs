#FROM gradle:8.1.1-jdk17
#ADD . /code
#WORKDIR /code
#RUN gradle clean build
#CMD gradle bootRun

FROM gradle:8.1.1-jdk17
ADD build/libs /app
WORKDIR /app
CMD java -jar prometheus-stack-0.0.1-SNAPSHOT.jar