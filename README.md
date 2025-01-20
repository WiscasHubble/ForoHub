# 📚 **ForoHub**

**ForoHub** es una API REST desarrollada con **Spring Boot** que permite gestionar foros de discusión. A través de esta API, los usuarios pueden registrarse, crear temas de discusión, actualizar, listar y eliminar tópicos. La API también está protegida con autenticación JWT para garantizar que solo los usuarios autenticados puedan interactuar con los datos. Este proyecto fue creado para aprender sobre el desarrollo de APIs RESTful, autenticación con JWT, y el manejo de bases de datos con Spring Boot.

## 🚀 **Características principales**

1. **Autenticación de usuario**  
    Los usuarios pueden iniciar sesión utilizando sus credenciales (correo y contraseña) para obtener un token JWT que les permite interactuar con los endpoints protegidos de la API.
    
2. **Registrar un tópico**  
    Permite a los usuarios crear un nuevo tópico de discusión, proporcionando información como título, mensaje, fecha de creación, estado y curso asociado.
    
3. **Actualizar un tópico existente**  
    Los usuarios pueden actualizar los detalles de un tópico ya creado, incluyendo su título, mensaje, estado y curso.
    
4. **Listar tópicos**  
    Permite obtener una lista de todos los tópicos registrados, con paginación para facilitar la navegación.
    
5. **Eliminar un tópico**  
    Los usuarios pueden eliminar un tópico de la base de datos proporcionando su ID.
    
6. **Protección con JWT**  
    Todas las rutas (excepto la de login) requieren autenticación con un token JWT obtenido al iniciar sesión.

## 📥 **Instalación y configuración**

### **Requisitos previos**

- **Java 17** o superior instalado (puedes descargarlo desde [aquí](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)).
- **Spring Boot**: Framework principal utilizado para el desarrollo de la aplicación.
- **PostgreSQL**: Base de datos utilizada para almacenar la información.

#### **Recomendaciones**

- Instalar [IntelliJ IDEA](https://www.jetbrains.com/idea/download/?section=windows).
- Crear un nuevo proyecto **Spring Boot** con **Java 17**.
- Clonar el repositorio del proyecto desde:

```git

git clone https://github.com/TuUsuario/ForoHub.git`

```


#### **Base de Datos**

Configura tu base de datos PostgreSQL con los parámetros necesarios en el archivo `application.properties`.

#### **Configuración de la base de datos**

Asegúrate de que la base de datos PostgreSQL esté configurada correctamente, y ejecuta las migraciones con Flyway para crear las tablas necesarias.

## 🛠️ **Tecnologías utilizadas**

- [**Java 17**](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html): Lenguaje principal del proyecto.
- [**Spring Boot**](https://spring.io/projects/spring-boot): Framework para crear aplicaciones Java de manera rápida y sencilla.
- [**Spring Security**](https://spring.io/projects/spring-security): Para la autenticación y autorización de usuarios mediante JWT.
- [**Spring Data JPA**](https://spring.io/projects/spring-data-jpa): Para la integración de Spring Boot con bases de datos, facilitando el acceso y manipulación de los datos.
- [**Flyway**](https://flywaydb.org/): Herramienta para gestionar las migraciones de la base de datos.
- [**PostgreSQL**](https://www.postgresql.org/): Sistema de gestión de bases de datos utilizado para almacenar la información.
- [**Java JWT**](https://github.com/auth0/java-jwt): Biblioteca utilizada para la creación y verificación de tokens JWT en Java, facilitando la implementación de la autenticación basada en JWT en el proyecto.


## 📦 **Dependencias**

El proyecto utiliza las siguientes dependencias de Maven:

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>

<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
</dependency>

<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-web</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-config</artifactId>
</dependency>

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <scope>provided</scope>
</dependency>

<dependency>
  <groupId>com.auth0</groupId>
  <artifactId>java-jwt</artifactId>
  <version>4.4.0</version>
</dependency>



```


## 📜 **EndPoints**

### **Autenticación**

- **POST** `/login`:  
    Inicia sesión con las credenciales del usuario (correo y contraseña) y devuelve un token JWT.
    
    **Ejemplo de cuerpo de la solicitud**:

```json

{
  "correo": "usuario@ejemplo.com",
  "contraseña": "miContraseñaSegura"
}


```

### **Tópicos**

1. **Registrar un tópico**
    
    - **POST** `/topicos/create`  
        Crea un nuevo tópico de discusión.
    
    **Ejemplo de cuerpo de la solicitud**:

```json

{
  "titulo": "Problema con la base de datos",
  "mensaje": "El sistema no está guardando los datos correctamente, ya revisé la conexión y los parámetros.",
  "fechaDeCreacion": "2025",
  "status": false,
  "curso": "CONVERSOR"
}

```

**Actualizar un tópico**

- **PUT** `/topicos`  
    Actualiza los detalles de un tópico ya existente.

**Ejemplo de cuerpo de la solicitud**:

```json

{
  "id": 1,
  "titulo": "Gracias, ya pude...",
  "mensaje": "Lo solucioné de la siguiente manera...",
  "fechaDeCreacion": "2024",
  "status": true,
  "curso": "FORO"
}

```

- **Listar tópicos**
    
    - **GET** `/topicos`  
        Obtiene una lista de todos los tópicos.
- **Eliminar un tópico**
    
    - **DELETE** `/topicos/{id}`  
        Elimina un tópico específico por su ID.

### **Autenticación requerida**

Para acceder a los endpoints de creación, actualización, eliminación y listado de tópicos, es necesario incluir el encabezado `Authorization` con el token JWT obtenido en el login.

## 🤝 **Contribuciones**

¡Las contribuciones son bienvenidas! Si deseas colaborar:

1. Haz un fork del repositorio.
2. Crea una rama con tu mejora: `git checkout -b mejora-nueva-funcionalidad`.
3. Realiza un commit: `git commit -m "Añadir nueva funcionalidad"`.
4. Envía un pull request.
