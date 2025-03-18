# MeloVault

**Versión:** 1.0.0

## Descripción

MeloVault es una aplicación en Java que implementa el patrón DAO para gestionar una biblioteca musical. Utiliza MySQL como base de datos, JDBC para la conexión y Maven como sistema de construcción. El proyecto se desarrolló en IntelliJ IDEA y permite realizar operaciones CRUD básicas sobre canciones.

## Características

- Gestión de canciones (crear, leer, actualizar y eliminar)
- Búsqueda de canciones por ID, artista, género, álbum o año
- Conexión a base de datos MySQL utilizando JDBC
- Uso del patrón de diseño DAO

## Requisitos

- Java 8 o superior
- Maven
- MySQL

## Instalación y Configuración

1. **Clonar el repositorio:**

   ```bash
   git clone https://github.com/tu_usuario/MeloVault.git
   ```
2. **Configurar la base de datos:**

   ```sql
   CREATE DATABASE melo_vault_db;
    USE melo_vault_db;
    CREATE TABLE song (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    artist VARCHAR(100) NOT NULL,
    album VARCHAR(100),
    genre VARCHAR(50),
    year INT,
    url VARCHAR(255));
   ```
3. **Configurar la conexión:**

   Edita el archivo de configuración (por ejemplo, DatabaseConnection.java) para establecer tu URL, usuario y contraseña de     MySQL.

5. **Compilar y ejecutar el proyecto:**
   
    ```bash
    mvn clean install
    mvn exec:java -Dexec.mainClass="melo_vault.App"
    ```
## Uso

El proyecto te permite:
- Listar todas las canciones
- Buscar canciones por diversos criterios (ID, artista, género, álbum, año)
- Agregar nuevas canciones
- Actualizar datos de una canción existente
- Eliminar canciones

## Versionado
La versión actual del proyecto es **1.0.0**.
