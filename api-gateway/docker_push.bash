cd C:\WS-atessoft\ecommerce\api-gateway

docker build -t api-gateway .

docker login

docker tag api-gateway harunates/api-gateway

docker push harunates/api-gateway