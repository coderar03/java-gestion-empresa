#!/bin/bash

echo "Creando estructura profesional del proyecto Java..."

# --- ESTRUCTURA MAVEN ---
mkdir -p src/main/java/model
mkdir -p src/main/java/interfaces
mkdir -p src/main/java/exceptions
mkdir -p src/main/java/services
mkdir -p src/main/java/app
mkdir -p src/main/resources
mkdir -p src/test/java

# --- .gitkeep PARA TODAS LAS CARPETAS MAVEN ---
touch src/main/java/model/.gitkeep
touch src/main/java/interfaces/.gitkeep
touch src/main/java/exceptions/.gitkeep
touch src/main/java/services/.gitkeep
touch src/main/java/app/.gitkeep
touch src/main/resources/.gitkeep
touch src/test/java/.gitkeep

# --- DOCKER ---
mkdir -p docker
touch docker/Dockerfile

# --- AWS ---
mkdir -p aws/lambda-handlers
mkdir -p aws/api-gateway-config
touch aws/dynamodb-schema.json

# --- .gitkeep PARA CARPETAS AWS VACÍAS ---
touch aws/lambda-handlers/.gitkeep
touch aws/api-gateway-config/.gitkeep

# --- DOCUMENTACIÓN ---
mkdir -p docs
touch docs/arquitectura-local.pdf
touch docs/arquitectura-cloud.pdf
touch docs/uml-clases.png

# --- SCRIPTS (NO se crea la carpeta, solo los archivos si ya existe) ---
touch scripts/build.sh
touch scripts/deploy-lambda.sh

# --- POM.XML ---
touch pom.xml

echo "Estructura creada correctamente."