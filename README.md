## Microservice with Docker + Spring Boot + Ribbon Load Balance + Consul + Docker Scale without Registrator
Requirements: Docker, Maven, Java
<br>
<br>
for run this example:
<br>
<br>
<b>mvn clean install -DskipTests</b>
<br>
<b>docker build -t poc-ribbon-consul .</b>
<br>
<b>docker-compose -f poc-ribbon-compose.yml up -d</b>
<br>
<b>docker-compose -f poc-ribbon-compose.yml scale poc-ribbon-consul=2</b>
<br>
<b>curl --noproxy "*" http://localhost:port/clientLoadBalance </b>
<br>
<br>
OSB: Because ports generate dynamically, you need check port in consul or docker logs for curl.


