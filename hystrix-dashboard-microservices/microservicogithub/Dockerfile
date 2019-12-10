FROM ubuntu:18.04

RUN apt-get -y update \
  && apt-get -y upgrade \
  && apt-get -y install openjdk-8-jdk wget \
  && mkdir /usr/local/github/

COPY ./build/libs/*.jar /usr/local/github/

WORKDIR /usr/local/github/

EXPOSE 8080

ENTRYPOINT ["java","-jar","microservicogithub.jar"]