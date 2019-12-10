FROM ubuntu:18.04

RUN apt-get -y update \
  && apt-get -y upgrade \
  && apt-get -y install openjdk-8-jdk wget \
  && mkdir /usr/local/tomcat \
  && wget http://www-us.apache.org/dist/tomcat/tomcat-9/v9.0.24/bin/apache-tomcat-9.0.24.tar.gz -O /tmp/tomcat.tar.gz \
  && cd /tmp \
  && tar xvfz tomcat.tar.gz \
  && cp -Rv /tmp/apache-tomcat-9.0.24/* /usr/local/tomcat/

COPY /build/libs/rest-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]