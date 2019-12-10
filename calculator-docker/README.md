#1- Instalação do Docker
Abra o terminal linux e digite os seguintes comandos nesta ordem:
->sudo apt-get update
->sudo apt install docker.io
->sudo systemctl start docker
->sudo systemctl enable docker

#2- Gerando arquivo arquivo.war
Na raiz do seu projeto caso esteja usando Gradle vá até o arquivo build.gradle e adicione o plugin (id 'war')
Digite no seu terminal o comando: ./gradle clean build ou ./gradle war para gerar o arquivo.war
Procure a pasta do seu projeto e ache a pasta ("build") e dentro da pasta libs você encontrará seu arquivo.war.

#3- Criando Arquivo Dockerfile
Na raiz do projeto crie um novo file com o nome exatamente do mesmo jeito que esta entre aspas "Dockerfile", para configuralo entre com o seguinte código.

FROM ubuntu:18.04

RUN apt-get -y update \
  && apt-get -y upgrade \
  && apt-get -y install openjdk-8-jdk wget \
  && mkdir /usr/local/tomcat \
  && wget http://www-us.apache.org/dist/tomcat/tomcat-9/v9.0.24/bin/apache-tomcat-9.0.24.tar.gz -O /tmp/tomcat.tar.gz \
  && cd /tmp \
  && tar xvfz tomcat.tar.gz \
  && cp -Rv /tmp/apache-tomcat-9.0.24/* /usr/local/tomcat/

COPY /build/libs/"NOME DO SEU ARQUIVO".war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]

Após criar este arquivo execute os seguintes comandos em seu terminal: 
sudo docker build -t ubuntu:1 .
sudo docker run -p 8080:8080 ubuntu:1

Pronto, o Docker já esta rodando.

#3- Como utilizar a aplicação
Esta calculadora contém as seguintes operações: soma, subtração, multiplicação, divisão e potênciação. OBS: As operações devem ser aplicadas baseado na Tabela ASCII: 
Soma: %2B 
Subtração: - 
Multiplicação: %2A 
Divisão: %2F 
Potência: %5E
Abra a aplicação pela URL http://localhost:8080/"NOME DO SEU ARQUIVO.WAR"/calculadora?operacao="OPERAÇÃO EM CARACTER ASCII"numeroUm="PRIMEIRO VALOR"&numeroDois="SEGUNDO VALOR"
No campo "OPERAÇÃO EM CARACTER ASCII" devemos passar a operação desejada em caracter ASCII como informado anteriormente (sem as aspas) e nos campos "PRIMEIRO VALOR" e "SEGUNDO VALOR" (sem as aspas) os valores para sua operação.
Para acessar o histórico de operações acesse a URL http://localhost:8080/"NOME DO SEU ARQUIVO.WAR"/historico