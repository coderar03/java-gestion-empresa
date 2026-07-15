Write-Host "Creando estructura profesional del proyecto Java..." -ForegroundColor Cyan

mkdir src/main/java/model
mkdir src/main/java/interfaces
mkdir src/main/java/exceptions
mkdir src/main/java/services
mkdir src/main/java/app
mkdir src/main/resources

mkdir src/test/java

mkdir docker
New-Item docker/Dockerfile -ItemType File

mkdir aws
mkdir aws/lambda-handlers
mkdir aws/api-gateway-config
New-Item aws/dynamodb-schema.json -ItemType File

mkdir docs
New-Item docs/arquitectura-local.pdf -ItemType File
New-Item docs/arquitectura-cloud.pdf -ItemType File
New-Item docs/uml-clases.png -ItemType File

mkdir scripts
New-Item scripts/build.sh -ItemType File
New-Item scripts/deploy-lambda.sh -ItemType File

New-Item pom.xml -ItemType File

Write-Host "Estructura creada correctamente." -ForegroundColor Green