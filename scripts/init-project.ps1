Write-Host "Creando estructura profesional del proyecto Java..." -ForegroundColor Cyan

# --- ESTRUCTURA MAVEN PROFESIONAL ---
mkdir src/main/java/com/empresa/model
mkdir src/main/java/com/empresa/interfaces
mkdir src/main/java/com/empresa/exceptions
mkdir src/main/java/com/empresa/services
mkdir src/main/java/com/empresa/app
mkdir src/main/resources
mkdir src/test/java

# --- .gitkeep PARA TODAS LAS CARPETAS MAVEN ---
New-Item src/main/java/com/empresa/model/.gitkeep -ItemType File -Force | Out-Null
New-Item src/main/java/com/empresa/interfaces/.gitkeep -ItemType File -Force | Out-Null
New-Item src/main/java/com/empresa/exceptions/.gitkeep -ItemType File -Force | Out-Null
New-Item src/main/java/com/empresa/services/.gitkeep -ItemType File -Force | Out-Null
New-Item src/main/java/com/empresa/app/.gitkeep -ItemType File -Force | Out-Null
New-Item src/main/resources/.gitkeep -ItemType File -Force | Out-Null
New-Item src/test/java/.gitkeep -ItemType File -Force | Out-Null

# --- DOCKER ---
mkdir docker
New-Item docker/Dockerfile -ItemType File -Force | Out-Null

# --- AWS ---
mkdir aws
mkdir aws/lambda-handlers
mkdir aws/api-gateway-config
New-Item aws/dynamodb-schema.json -ItemType File -Force | Out-Null

# --- .gitkeep PARA CARPETAS AWS VACÍAS ---
New-Item aws/lambda-handlers/.gitkeep -ItemType File -Force | Out-Null
New-Item aws/api-gateway-config/.gitkeep -ItemType File -Force | Out-Null

# --- DOCUMENTACIÓN ---
mkdir docs
New-Item docs/arquitectura-local.pdf -ItemType File -Force | Out-Null
New-Item docs/arquitectura-cloud.pdf -ItemType File -Force | Out-Null
New-Item docs/uml-clases.png -ItemType File -Force | Out-Null

# --- SCRIPTS ---
New-Item scripts/build.sh -ItemType File -Force | Out-Null
New-Item scripts/deploy-lambda.sh -ItemType File -Force | Out-Null

# --- POM.XML ---
New-Item pom.xml -ItemType File -Force | Out-Null

Write-Host "Estructura creada correctamente." -ForegroundColor Green
