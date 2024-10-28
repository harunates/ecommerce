cd C:\WS-atessoft\ecommerce\notification-service

docker build -t notification-service .

docker login

docker tag notification-service harunates/notification-service

docker push harunates/notification-service