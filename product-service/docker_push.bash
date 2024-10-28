cd C:\WS-atessoft\ecommerce\product-service

docker build -t product-service .

docker login

docker tag product-service harunates/product-service

docker push harunates/product-service