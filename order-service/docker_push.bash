cd C:\WS-atessoft\ecommerce\order-service

docker build -t order-service .

docker login

docker tag order-service harunates/order-service

docker push harunates/order-service