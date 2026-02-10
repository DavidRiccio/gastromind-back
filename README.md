# GastroMind API: El Cerebro de la Cocina Inteligente 🧠🍎

GastroMind no es solo una lista de la compra o un recetario; es un ecosistema de Inteligencia Artificial diseñado para optimizar la economía doméstica y erradicar el desperdicio alimentario. Actúa como el centro neurálgico que conecta el ticket de compra, el inventario real y la mesa del usuario.

A diferencia de las soluciones pasivas, GastroMind es proactiva:
- **Conciencia de Inventario:** Sabe qué tienes y cuándo caduca.
- **Conciencia de Equipo (Hardware Aware):** Filtra su conocimiento basándose en tus electrodomésticos (Air Fryer, Horno, etc.).
- **Economía Circular:** Transforma datos de tickets borrosos en analíticas de gasto y stock en tiempo real mediante IA Multimodal.

Este es un motor API REST diseñado para procesar grandes volúmenes de datos de inventario, gestionar la seguridad alimentaria de múltiples hogares y servir como puente seguro entre la base de datos relacional.

## 🏗️ Arquitectura del Proyecto

El proyecto sigue una **Arquitectura Hexagonal (Puertos y Adaptadores)**, lo que permite una total independencia entre la lógica de negocio (núcleo) y las tecnologías externas (bases de datos, frameworks, APIs).

### Estructura de Paquetes

* **`domain`**: Contiene el corazón de la aplicación. Modelos de negocio pura, excepciones de dominio e interfaces (puertos) que definen cómo el sistema interactúa con el exterior.
* **`infrastructure`**: Implementación de los adaptadores.
* **`adapters.in.rest`**: Controladores que exponen la API y gestión global de excepciones.
* **`adapters.out.persistence`**: Implementaciones de persistencia utilizando **PostgreSQL** (JPA) y **MongoDB**.


* **`security`**: Configuración centralizada de seguridad, gestión de JWT y políticas de acceso.

---

## 🛠️ Tecnologías y Dependencias

El stack tecnológico ha sido seleccionado para garantizar escalabilidad, seguridad y una documentación automática robusta.

### Core Framework

* **Spring Boot 3**: Framework base para el desarrollo de microservicios.
* **Spring Security & JWT**: Implementación de seguridad basada en tokens para una autenticación stateless.
* **Validation**: Aseguramiento de la integridad de los datos de entrada mediante anotaciones.

### Persistencia y Datos

* **Spring Data JPA & PostgreSQL**: Gestión de datos relacionales para usuarios y hogares.
* **Spring Data MongoDB**: Almacenamiento flexible para registros de inventario o logs.
* **MapStruct**: Mapeo eficiente de objetos entre capas (DTOs, Domain Models y Entities) para mantener el desacoplamiento.

### Documentación y Desarrollo

* **SpringDoc OpenAPI (Swagger)**: Interfaz interactiva para pruebas y documentación técnica de los endpoints.
* **Docker Compose Support**: Gestión automatizada del entorno de desarrollo (PostgreSQL, MongoDB, pgAdmin) integrada con Spring Boot.

---

## 🐳 Entorno de Desarrollo (Docker)

La infraestructura local se levanta de forma automatizada mediante contenedores, facilitando el despliegue inmediato del entorno de base de datos y herramientas de administración.

| Servicio | Puerto | Descripción |
| --- | --- | --- |
| **PostgreSQL** | `5432` | Base de datos relacional principal. |
| **MongoDB** | `27017` | Almacenamiento de documentos no relacionales. |
| **pgAdmin** | `5050` | Panel de administración web para PostgreSQL. |
