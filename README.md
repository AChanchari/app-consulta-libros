# 📚 Book Finder App

Esta es una aplicación desarrollada en **Java** utilizando **Spring Boot** que permite buscar libros por título consumiendo la API pública de [Gutendex](https://gutendex.com/). El objetivo es facilitar la búsqueda de libros clásicos y de dominio público.

## 🚀 Características

- 🔎 Búsqueda de libros por título.
- 🌐 Consumo de API REST (https://gutendex.com/).
- ☕ Backend desarrollado con Java y Spring Boot.
- 📦 Uso de la librería `jackson-databind` para manejar el parseo de JSON.

## 🛠️ Tecnologías utilizadas

- Java 17+
- Spring Boot
- Maven
- Jackson Databind
- Gutendex API

## 🧩 Dependencias

El proyecto utiliza Maven para la gestión de dependencias. En el archivo `pom.xml`, se ha agregado:

```xml
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>2.19.0</version>
</dependency>
```

## 📦 Instalación y ejecución

1. Clona este repositorio:
   ```bash
   git clone https://github.com/AChanchari/app-consulta-libros.git
   cd app-consulta-libros
   ```

2. Compila y ejecuta el proyecto con Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

   > En Windows, si `./mvnw` no funciona, usa:
   ```bash
   mvnw.cmd spring-boot:run
   ```

3. La aplicación se ejecutará en la terminal y te pedirá que ingreses el nombre de un libro:

   ```text
   Ingrese el nombre del libro que deseas buscar:
   ```

   Después de escribir el nombre del libro (por ejemplo: `quijote`), verás los resultados directamente en la consola, incluyendo título, autor, idioma y estadísticas de descargas.

---

### 📌 Nota

- La búsqueda se realiza únicamente por el título correcto del libro.
- Esta aplicación es un proyecto personal creado con fines educativos y para práctica del consumo de APIs REST en Java con Spring Boot.

## 📚 API Gutendex

Esta app se conecta a: [https://gutendex.com/books/](https://gutendex.com/books/)

Ejemplo de consulta:
```
https://gutendex.com/books/?search=orgullo+y+prejuicio
```

## ✨ Autor

- **Anngie Chanchari**  
  Desarrolladora en formación | Apasionada por el backend y el aprendizaje constante  
  [GitHub](https://github.com/AChanchari)

---

¡Gracias por visitar este proyecto! 😊
