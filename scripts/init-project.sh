#!/bin/bash

echo "Creando estructura profesional del proyecto Java..."

mkdir -p src/main/java/model
mkdir -p src/main/java/interfaces
mkdir -p src/main/java/exceptions
mkdir -p src/main/java/services
mkdir -p src/main/java/app
mkdir -p src/main/resources

mkdir -p src/test/java

mkdir -p docker
touch docker/Dockerfile

mkdir -p aws/lambda-handlers
mkdir -p aws/api-gateway-config
touch aws/dynamodb-schema.json

mkdir -p docs
touch docs/arquitectura-local.pdf
touch docs/arquitectura-cloud.pdf
touch docs/uml-clases.png

mkdir -p scripts
touch scripts/build.sh
touch scripts/deploy-lambda.sh

touch pom.xml

echo "Estructura creada correctamente."