# Foro_Hub 💬 - API REST para Gestión de Tópicos

Foro_Hub es una API REST desarrollada en Java con Spring Boot, diseñada para la gestión de tópicos de discusión. Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los tópicos, incluyendo funcionalidades de listado con paginación y búsqueda, así como un manejo robusto de excepciones. El proyecto sigue principios de diseño de API REST y buenas prácticas de desarrollo.

---

🚀 **Tecnologías utilizadas**

* **Java 17**
* **Spring Boot 3.5.4**
* **Maven**
* **MySQL 10.4.32-MariaDB**
* **JPA + Spring Data**
* **Flyway** (para migraciones de base de datos)
* **Lombok** (para reducir código boilerplate)
* **Jakarta Validation** (para validación de datos)
* **Spring Security** (para autenticación y autorización)
* **Auth0 JWT (java-jwt)** (para generación y validación de tokens JWT)
* **Insomnia** (para pruebas de API)
* **Spring Mail** (para envío de correos electrónicos)
* **OpenAPI (con Springdoc)** (para documentar los endpoints)

---
---
✅ **Funcionalidades implementadas**

1.  **Configuración inicial y persistencia de datos:**

    *   Proyecto Maven con dependencias esenciales.

    *   Uso de Flyway para gestionar migraciones de base de datos, incluyendo la creación de tablas y precarga de datos (curso, usuario, perfil).

2.  **Registro de un nuevo Tópico (POST):**

    *   Endpoint: POST /topicos

    *   Permite crear un nuevo tópico validando los datos de entrada.

    *   Manejo de excepción para tópicos duplicados (título y mensaje).

3.  **Listado de Tópicos (GET):**

    *   **Listar todos con paginación:** GET /topicos

        *   Soporta paginación (size, page, sort) con @PageableDefault.

    *   **Listar los primeros 10:** GET /topicos/primeros10topicos

        *   Obtiene los 10 tópicos más recientes ordenados por fecha de creación.

    *   **Búsqueda por criterios:** GET /topicos/buscar?titulo={titulo}&anio={anio}

        *   Permite buscar tópicos por una parte del título y por el año de creación.

4.  **Detalle de un Tópico (GET por ID):**

    *   Endpoint: GET /topicos/{id}

    *   Muestra la información detallada de un tópico específico.

    *   Manejo de excepción 404 Not Found si el tópico no existe.

5.  **Actualización de un Tópico (PUT):**

    *   Endpoint: PUT /topicos/{id}

    *   Permite actualizar los datos de un tópico existente (título, mensaje, status, curso).

    *   Validaciones aplicadas a los datos de entrada.

    *   Manejo de excepciones para tópicos no encontrados o datos duplicados.

6.  **Eliminación de un Tópico (DELETE):**

    *   Endpoint: DELETE /topicos/{id}

    *   Elimina un tópico de la base de datos por su ID.

    *   Manejo de excepción 404 Not Found si el tópico no existe antes de intentar eliminarlo.

7.  **Manejo de Excepciones Global:**

    *   Implementación de TopicoDuplicadoException y TopicoNoEncontradoException para manejar errores de negocio de forma específica.

    *   Configuración de un manejador de excepciones global (@ControllerAdvice) para mapear estas excepciones a códigos de estado HTTP apropiados (ej. 409 Conflict, 404 Not Found). Ahora también maneja errores de autenticación como 401 Unauthorized.

8.  **Gestión de Usuarios y Perfiles:**

    *   Endpoint de Usuarios: Permite a los usuarios consultar y eliminar su propio registro.

    *   Control de Acceso por Perfil: Implementación de lógica de autorización para que los administradores puedan realizar acciones específicas, mientras que los usuarios normales tienen permisos restringidos a sus propios datos.

9.  **Gestión de Respuestas:**

    *   Se agregó un nuevo endpoint y lógica para manejar las respuestas a los tópicos.

10.  **Notificaciones por Correo Electrónico:**

*   Se implementó la lógica para enviar un correo electrónico al usuario con su contraseña al registrarse, utilizando Spring Mail.

11.  **Autenticación y Control de Acceso con JWT:**

*   Endpoint de Login: POST /login para autenticar usuarios y generar un token JWT.

*   Generación y Validación de Tokens JWT: Creación de tokens JWT seguros (HMAC256) con información del emisor y fecha de expiración. El SecurityFilter se encarga de interceptar y validar el token en cada solicitud protegida.

*   Control de Acceso por ID: La lógica de seguridad se ha mejorado para verificar si el id del usuario en el token JWT coincide con el id del recurso que se intenta modificar o eliminar, garantizando que un usuario solo pueda actuar sobre sus propios datos.

*   Configuración de Seguridad: Spring Security configurado para ser sin estado (STATELESS), deshabilitar CSRF, permitir el acceso a /login y requerir autenticación para todas las demás rutas.

*   Encriptación de Contraseñas: Uso de BCryptPasswordEncoder para almacenar contraseñas de forma segura en la base de datos.
---
