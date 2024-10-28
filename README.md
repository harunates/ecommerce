# E-commerce Microservices Application

### Tech Stack Used
<div>
    <table>
        <tr>
            <td>
                <strong>Languages & Frameworks</strong>
            </td>
            <td>
                <a href="ttps://www.java.com/en/">
                    <img alt="Java" src="https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white"/>
                </a>
                &emsp;
                <a href="https://spring.io/projects/spring-boot" target="_blank">
                    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat&logo=springboot&logoColor=white">
                </a>
                &emsp;
                <a href="https://spring.io/projects/spring-cloud" target="_blank">
                    <img alt="Spring Cloud" src="https://img.shields.io/badge/Spring Cloud-6DB33F?style=flat&logo=spring&logoColor=white">
                </a>
                &emsp;
            </td>
        </tr>
        <tr>
            <td>
                <strong>Databases & Message Queue</strong>
            </td>
            <td>
                <a href="https://mysql.com/" target="_blank"> 
                    <img alt="MySQL" src="https://img.shields.io/badge/MySQL-00000F?style=flat&logo=mysql&logoColor=white"/>
                </a>
                &emsp;
                <a href="https://kafka.apache.org/" target="_blank"> 
                    <img alt="Apache Kafka" src="https://img.shields.io/badge/Apache%20Kafka-000?style=flat&logo=apachekafka"/>
                </a>
                &emsp;
            </td>
        </tr>
        <tr>
            <td>
                <strong>API Gateway</strong>
            </td>
            <td>
                <a href="https://spring.io/projects/spring-cloud-gateway" target="_blank"> 
                    <img alt="Spring Cloud Gateway" src="https://img.shields.io/badge/Spring Cloud Gateway-6DB33F.svg?&style=flat&logo=spring&logoColor=white"/>
                </a>
                &emsp;
            </td>
        </tr>
        <tr>
            <td>
                <strong>Service Discovery</strong>
            </td>
            <td>
                <a href="https://spring.io/projects/spring-cloud-netflix" target="_blank"> 
                    <img alt="Netflix Eureka" src="https://img.shields.io/badge/Eureka-DF162B.svg?&style=flat&logo=netflix&logoColor=white"/>
                </a>
                &emsp;
            </td>
        </tr>
        <tr>
            <td>
                <strong>Circuit Breaker</strong>
            </td>
            <td>
                <a href="https://resilience4j.readme.io/" target="_blank"> 
                    <img alt="Resilience4J" src="https://img.shields.io/badge/Resilience4J-121212.svg?&style=flat&logo=resilience4j&logoColor=white"/>
                </a>
                &emsp;
            </td>
        </tr>
        <tr>
            <td>
                <strong>Observability</strong>
            </td>
            <td>
                <a href="https://micrometer.io/" target="_blank"> 
                    <img alt="Micrometer" src="https://img.shields.io/badge/Micrometer-117A71.svg?&style=flat&logo=micrometer&logoColor=white"/>
                </a>
                &emsp;
                <a href="https://zipkin.io/" target="_blank"> 
                    <img alt="Zipkin" src="https://img.shields.io/badge/Zipkin-FE7139.svg?&style=flat&logo=zipkin&logoColor=white"/>
                </a>
                &emsp;
                <a href="https://prometheus.io/" target="_blank"> 
                    <img alt="Prometheus" src="https://img.shields.io/badge/Prometheus-E6522C.svg?&style=flat&logo=prometheus&logoColor=white"/>
                </a>
                &emsp;
                <a href="https://grafana.com/" target="_blank"> 
                    <img alt="Grafana" src="https://img.shields.io/badge/Grafana-F79A2F.svg?&style=flat&logo=grafana&logoColor=white"/>
                </a>
                &emsp;
            </td>
        </tr>
        <tr>
            <td>
                <strong>Build & Containerization</strong>
            </td>
            <td>
                <a href="https://maven.apache.org/" target="_blank"> 
                    <img alt="Maven" src="https://img.shields.io/badge/Maven-C02748?style=flat&logo=apachemaven&logoColor=white"/>
                </a>
                &emsp;
                <a href="https://www.docker.com/" target="_blank"> 
                    <img alt="Docker" src="https://img.shields.io/badge/Docker-2496ED?style=flat&logo=docker&logoColor=white"/>
                </a>
                &emsp;
                <a href="https://github.com/GoogleContainerTools/jib" target="_blank"> 
                    <img alt="Jib" src="https://img.shields.io/badge/Jib-FF6444?style=flat&logo=googlecloud&logoColor=white"/>
                </a>
                &emsp;
            </td>
        </tr>
    </table>
</div>


## Getting Started

### Prerequisites
1. Docker and Docker Compose should be installed.
2. Docker should be running.

### Deployment

1. Navigate to the project directory:
   ```shell
   cd ecommerce\docker-compose
   ```

2. Start the containers:
   ```shell
   docker compose up -d
   ```

3. Confirm that the containers are up and running:
   ```shell
   docker ps
   ```


## Environment Cleanup

- To completely stop and remove the containers and other resources (network, volume, etc.), run the following command:
   ```shell
   docker compose down -v
   ```
