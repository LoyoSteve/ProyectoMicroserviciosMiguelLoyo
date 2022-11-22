#!/usr/bin/env bash

cd arquitectura-discovery-server
./generaImagen.sh

cd ../

cd arquitectura-monitor-server
./generaImagen.sh
cd ../

cd arquitectura-gateway
./generaImagen.sh
cd ../

cd entity-service-usuarios
./generaImagen.sh
cd ../

cd entity-service-publicaciones
./generaImagen.sh
cd ../

cd entity-service-comentarios
./generaImagen.sh
cd ../

cd entity-service-amigos
./generaImagen.sh
cd ../

cd entity-service-estados
./generaImagen.sh
cd ../

docker-compose up --build

docker-compose stop
docker-compose kill
docker-compose rm -f
