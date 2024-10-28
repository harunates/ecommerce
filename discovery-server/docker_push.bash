cd C:\WS-atessoft\ecommerce\discovery-server

docker build -t discovery-server .

docker login

docker tag discovery-server harunates/discovery-server

docker push harunates/discovery-server