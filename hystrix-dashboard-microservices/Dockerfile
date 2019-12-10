FROM ubuntu:18.04

RUN apt-get -y update \
  && apt-get -y upgrade \
  && apt-get -y install openjdk-8-jdk wget \
  && mkdir /usr/local/tema7

COPY ./build/libs/*.jar /usr/local/tema7/

WORKDIR /usr/local/tema7/

EXPOSE 8080

ENTRYPOINT ["java","-jar","microservico.jar"]