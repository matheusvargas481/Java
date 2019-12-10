FROM ubuntu:18.04

RUN apt-get -y update \
  && apt-get -y upgrade \
  && apt-get -y install openjdk-8-jdk wget \
  && mkdir /usr/local/twitter

COPY ./build/libs/*.jar ./src/main/resources/twitter4j.properties /usr/local/twitter/

WORKDIR /usr/local/twitter/

EXPOSE 8080

ENTRYPOINT ["java","-jar","microservicotwitter.jar"]