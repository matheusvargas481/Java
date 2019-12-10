# 1- Gerando arquivo arquivo.war
- Na raiz do seu projeto caso esteja usando Gradle vá até o arquivo build.gradle e adicione o plugin (id 'war')
- Digite no seu terminal o comando: ./gradle clean build ou ./gradle war para gerar o arquivo.war
- Procure a pasta do seu projeto e ache a pasta ("build") e dentro da pasta libs você encontrará seu arquivo.war.
# 2-  Instalação do Jetty
- Abra o terminal do ubuntu e digite o comando: curl -O http://apache.mirrors.ionfish.org/Jetty/Jetty-8/v8.5.5/bin/apache-Jetty-8.5.5.tar.gz
- Entre na pasta raiz onde seu Jetty foi instalado e procure a pasta webapps, após encontra - la cole seu arquivo.war que foi gerado a partir da sua aplicação.
- Após a instalação via terminal acesse a pasta onde seu Jetty foi instalado e execute o comando para startar o serviço: bin/catalina.sh start (OBS: para parar o serviço digite stop no local do start).
# 3- Como utilizar a aplicação 
- Esta calculadora contém as seguintes operações: soma, subtração, multiplicação, divisão e potênciação.
OBS: As operações devem ser aplicadas baseado na Tabela ASCII:
Soma: %2B
Subtração: -
Multiplicação: %2A
Divisão: %2F
Potência: %5E  
- Abra a aplicação pela URL http://localhost:8080/tema4/calculadora?operacao="OPERAÇÃO EM CARACTER ASCII"numeroUm="PRIMEIRO VALOR"&numeroDois="SEGUNDO VALOR"
- No campo "OPERAÇÃO EM CARACTER ASCII" devemos passar a operação desejada em caracter ASCII como informado anteriormente (sem as aspas) e nos campos "PRIMEIRO VALOR" e "SEGUNDO VALOR" (sem as aspas) os valores para sua operação.
- Para acessar o histórico de operações acesse a URL http://localhost:8080/tema4/historico