## Microservice with Docker + Spring Boot + Ribbon Load Balance + Consul + Docker Scale without Registrator
Requirements: Docker, Maven, Java
<br>
for run this example:
<br>
mvn clean install -DskipTests
<br>
docker build -t poc-ribbon-consul .
<br>
docker-compose -f poc-ribbon-compose.yml up -d
<br>
docker-compose -f poc-ribbon-compose.yml scale poc-ribbon-consul=2
<br>
curl --noproxy "*" http://localhost:port/clientLoadBalance
<br>
<br>
OSB: Because ports generate dynamically, you need check port in consul or docker logs for curl.


