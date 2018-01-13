## Microservice with Docker + Spring Boot + Ribbon Load Balance + Consul + Docker Scale without Registrator
<br>
for run this example:
<br>
Requirements: Docker, Maven, Java
<br>
<br>
* mvn clean install -DskipTests
* docker build -t poc-ribbon-consul .
* docker-compose -f poc-ribbon-compose.yml up -d
* docker-compose -f poc-ribbon-compose.yml scale poc-ribbon-consul=2
* curl --noproxy "*" http://localhost:port/clientLoadBalance
<br>
<br>
OSB: Because ports generate dynamically, you need check port in consul or docker logs for curl.


