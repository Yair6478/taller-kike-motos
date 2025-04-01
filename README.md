# Módulo de Gestión de Motos - Taller Kike Motos

Este módulo implementa la gestión de motocicletas para el taller Kike Motos, permitiendo realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre las motocicletas registradas en el sistema.

## Tecnologías Utilizadas

- Java 17
- Spring Boot 3.2.3
- PostgreSQL
- Maven
- Lombok
- MapStruct

## Estructura del Proyecto

```plaintext
com.taller.kike.motos
├── controller      # Controladores REST
│   └── MotoController.java
├── dto            # Objetos de transferencia de datos
│   └── MotoDTO.java
├── mapper         # Mappers para conversión entre entidades y DTOs
│   └── MotoMapper.java
├── model          # Entidades JPA
│   └── Moto.java
├── repository     # Repositorios JPA
│   └── MotoRepository.java
└── service        # Lógica de negocio
    └── MotoService.java
```

## Funcionalidades

El módulo proporciona las siguientes funcionalidades:

- Crear nuevas motocicletas
- Consultar todas las motocicletas
- Consultar motocicleta por ID
- Actualizar información de motocicletas
- Eliminar motocicletas
- Buscar motocicletas por marca
- Buscar motocicletas por modelo
- Filtrar motocicletas por estado

## Configuración

1. Requisitos previos:
    - Java 17
    - PostgreSQL
    - Maven

2. Base de datos:
    - Crear una base de datos en PostgreSQL llamada `taller_motos`
    - Usuario: postgres
    - Contraseña: postgres

3. Configuración de la aplicación:
    - El archivo `application.properties` contiene la configuración de la base de datos
    - Puerto de la aplicación: 8080

## Ejecución

1. Clonar el repositorio
2. Ejecutar: `mvn clean install`
3. Ejecutar: `mvn spring-boot:run`

La aplicación estará disponible en `http://localhost:8080`

## Endpoints API

### Motocicletas

- GET `/api/motos` - Obtener todas las motocicletas
- GET `/api/motos/{id}` - Obtener una motocicleta por ID
- POST `/api/motos` - Crear una nueva motocicleta
- PUT `/api/motos/{id}` - Actualizar una motocicleta existente
- DELETE `/api/motos/{id}` - Eliminar una motocicleta
- GET `/api/motos/marca/{marca}` - Buscar motocicletas por marca
- GET `/api/motos/modelo/{modelo}` - Buscar motocicletas por modelo
- GET `/api/motos/estado/{activo}` - Filtrar motocicletas por estado

## Autor

Yair Alfonso Cabrales Diaz

## Versión

1.0.0