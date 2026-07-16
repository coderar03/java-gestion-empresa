# Sistema de Gestión Empresarial (Java + Maven + Docker + AWS Free Tier)

## 1. Descripción general del proyecto
```text
El Sistema de Gestión Empresarial es una aplicación Java diseñada como ejercicio completo para aplicar Programación Orientada a Objetos avanzada, construcción profesional con Maven, contenedorización con Docker y despliegue gratuito en AWS Free Tier mediante Lambda, API Gateway, DynamoDB y S3.
```

## 2. Objetivos del ejercicio
- Clases abstractas, interfaces, herencia y polimorfismo.
- Colecciones y excepciones personalizadas.
- Lectura y escritura de ficheros.
- Modularización en paquetes.
- Construcción con Maven y generación de JAR ejecutable.
- Contenedorización con Docker.
- Adaptación a AWS Free Tier.
- Documentación técnica y repositorio Git profesional.

## 3. Tecnologías utilizadas
- Java 21  
- Maven 3.9.16  
- Gson 2.10.1  
- SLF4J + Logback  
- JUnit 5  
- Docker  
- AWS Free Tier (Lambda, API Gateway, DynamoDB, S3, CloudWatch)

## 4. Estructura del proyecto
```text
sistema-gestion-empresarial/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/empresa/
    │   │       ├── model/
    │   │       ├── interfaces/
    │   │       ├── exceptions/
    │   │       ├── services/
    │   │       ├── utils/
    │   │       └── app/
    │   └── resources/
    └── test/
        └── java/
```
## 5. Entidades del sistema
### Persona (abstracta)
- id
- nombre
- email
- mostrarInfo() (abstracto)

### Empleado (hereda de Persona)
- salario
- departamento
- salario anual

### Cliente (hereda de Persona)
- teléfono
- historialCompras (List)

### Interfaz OperacionesEmpresa
- registrarPersona(Persona p)
- eliminarPersona(int id)
- buscarPersona(String nombre)
- listarPersonas()

### Empresa (implementa OperacionesEmpresa)
- List<Empleado>
- List<Cliente>
- exportación/importación de ficheros
- validación de datos

## 6. Excepciones personalizadas
- PersonaNoEncontradaException
- FicheroException

## 7. Gestión de ficheros
- Exportación a .txt
- Importación desde .txt
- Validación de formato

## 8. Dependencias Maven
```xml
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>

    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>2.0.9</version>
    </dependency>

    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
        <version>1.4.14</version>
    </dependency>

    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.2</version>
        <scope>test</scope>
    </dependency>
```
## 9. Comandos Maven
```bash
    mvn clean
    mvn compile
    mvn package
```
### 10. Docker
```bash
    docker build -t sistema-empresa .
    docker run sistema-empresa
```
## 11. Adaptación a AWS Free Tier
### Lambda
- registrarPersona
- eliminarPersona
- buscarPersona
- listarPersonas

### API Gateway
- POST /persona
- DELETE /persona/{id}
- GET /persona?nombre=
- GET /personas

### DynamoDB
- Tabla Personas
    - PK: id
    - SK: tipo (Empleado/Cliente)
    
### S3
- /exportaciones/empresa.txt
- /logs/operaciones.log

### CloudWatch
- peticiones
- errores
- tiempos de ejecución

## 12. Repositorio Git
### Local
- código fuente
- documentación
- scripts
- Dockerfile
- diagrama UML
- commits profesionales

### Remoto (GitHub)
- README completo
- diagrama de clases
- arquitectura cloud
- instrucciones de despliegue

## 13. Criterios de evaluación
- POO avanzada
- Interfaces y herencia
- Colecciones
- Excepciones
- Modularización
- Maven
- Docker
- AWS Free Tier
- Documentación
- Git profesional

## 14. Extensiones opcionales
- Kubernetes con Minikube
- CI/CD con GitHub Actions
- CloudFront
- IAM avanzado