🌿 La Botiga de la Terra - Backend

Backend del sistema de diagnóstico para La Botiga de la Terra, desarrollado con Spring Boot.
Permite gestionar formularios de diagnóstico de usuarios, incluyendo estados, validaciones y lógica de negocio.

🚀 Tecnologías utilizadas
☕ Java 21
🌱 Spring Boot 3
🗄️ Spring Data JPA (Hibernate)
✅ Spring Validation
🐘 PostgreSQL
🔄 MapStruct (mappers)
🧩 Lombok
🌍 Dotenv (variables de entorno)
🧪 Postman (testing de endpoints)

🏗️ Arquitectura del sistema

El backend está diseñado siguiendo una arquitectura cliente-servidor y el patrón MVC (Modelo - Vista - Controlador) adaptado a una API REST en 3 capas.

🌐 Arquitectura Cliente - Servidor

Cliente (Frontend): Aplicación web que consume la API REST
Servidor (Backend): API desarrollada en Spring Boot que gestiona la lógica de negocio y acceso a datos

👉 Comunicación mediante HTTP + JSON

🧱 Arquitectura en 3 capas (Spring Boot)

El proyecto sigue una separación clara de responsabilidades:

1️⃣ Controller (Capa de presentación)

📂 controller

Expone los endpoints REST
Recibe peticiones HTTP
Valida inputs (@Valid)
Devuelve respuestas (DTOs)

📂 service

Contiene la lógica de negocio
Gestiona estados del formulario
Aplica reglas (ej: solo editar en DRAFT)
Orquesta operaciones entre repository y mapper

3️⃣ Repository (Capa de acceso a datos)

📂 repository

Comunicación con la base de datos
Uso de Spring Data JPA
Consultas automáticas (ej: findByUser)
🧩 Modelo de datos (Model)

📂 entity

Representa las tablas en base de datos
Uso de JPA / Hibernate
Relaciones:
@ManyToOne (User → Forms)
@ElementCollection (listas de condiciones)
🔄 DTOs (Data Transfer Objects)

📂 dto/request
📂 dto/response

Se utilizan para:

Separar la entidad de la API
Controlar qué datos se envían/reciben
Evitar exponer la base de datos
🔁 Mappers (MapStruct)

📂 mapper

Responsables de convertir:

DTO ⇄ Entity

Ventajas:

Código limpio
Menos boilerplate
Mayor mantenibilidad

📁 Estructura del proyecto
config/

controller/

dto/

 ├── request/
 
 └── response/
 
entity/

 └── enums/
 
mapper/

repository/

service/


🎯 Principios aplicados

Separación de responsabilidades (SRP)
Bajo acoplamiento
Alta cohesión
Arquitectura escalable
API RESTful

📦 Funcionalidades principales

Crear formularios de diagnóstico
Guardar formularios en estado DRAFT
Actualizar formularios (solo si están en DRAFT)
Obtener formulario por ID
Obtener formularios por usuario
Eliminar formularios (con validación de estado)
Gestión de estados:
DRAFT
PENDING_PAYMENT
SUBMITTED
COMPLETED

🔗 Frontend

El frontend del proyecto se encuentra en el siguiente repositorio:

👉 https://github.com/majoz-t/LaBotigadelaTerra-Front.git

🗄️ Base de datos

Se utiliza PostgreSQL.

Configurar en application.properties o .env:

spring.datasource.url=jdbc:postgresql://localhost:5432/tu_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

▶️ Cómo ejecutar el proyecto

Clonar el repositorio:
git clone https://github.com/tu-repo-back.git
Abrir en tu IDE (IntelliJ / VSCode)
Configurar base de datos
Ejecutar:
mvn spring-boot:run

🧪 Endpoints principales

Base URL:

http://localhost:8080/api/v1/diagnosticforms
📌 Crear formulario
POST /
📌 Actualizar formulario
PUT /{id}
📌 Obtener por ID
GET /{id}
📌 Obtener formularios del usuario
GET /userforms
📌 Eliminar formulario
DELETE /{id}

⚠️ Validaciones

Se implementan validaciones con jakarta.validation, por ejemplo:

Edad entre 0 y 120
Altura y peso positivos
Campos obligatorios
Selección mínima en listas

🔄 MapStruct

Se utiliza MapStruct para mapear:

DTO → Entity
Entity → DTO

Esto permite mantener el código limpio y desacoplado.

🧩 Lombok

@Data
@NoArgsConstructor

🧪 Testing

Las pruebas iniciales de endpoints se realizaron con Postman.

📌 Estado del proyecto

✔ Backend funcional
✔ CRUD completo (DiagnosticForm)
✔ Validaciones implementadas
✔ Arquitectura escalable

👩‍💻 Autora

Proyecto desarrollado por María José Ozta Castro 🌿
