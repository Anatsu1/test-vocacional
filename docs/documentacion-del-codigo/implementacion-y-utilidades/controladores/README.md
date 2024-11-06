---
description: Controladores para la la guia del modelo MVC web.
icon: rectangles-mixed
cover: ../../../.gitbook/assets/1721804475283.png
coverY: 0
layout:
  cover:
    visible: true
    size: hero
  title:
    visible: true
  description:
    visible: true
  tableOfContents:
    visible: true
  outline:
    visible: true
  pagination:
    visible: true
---

# Controladores

En el proyecto , se sigue el patrón de diseño MVC utilizando Spring Boot, el papel del controlador es fundamental debido a las siguientes razones:

* **Gestión de Rutas**: En este repositorio, los controladores establecen los endpoints que procesan las solicitudes HTTP, facilitando la navegación dentro de la aplicación.
* **Interacción con el Modelo**: Los controladores actúan como un puente, invocando los servicios del modelo para manejar datos, lo cual se observa en cómo encapsulan la lógica de negocio.
* **Preparación de Vistas**: Facilitan el paso de datos desde el modelo hacia las vistas, asegurando que la interfaz de usuario presente información actualizada y relevante.
* **Manejo de Excepciones**: Mejoran la robustez del sistema gestionando excepciones y errores a nivel de aplicación.

En este proyecto, los controladores son clave para integrar y coordinar los diferentes componentes, proporcionando una experiencia de usuario fluida y coherente. En nuestra aplicacion contamos con [`AlumnoController`](alumnocontroller.md) el controlador principal en base a las solicitudes HTTP (GET,POST,DELETE) y el encargado de llamar a los metodos de [`AlumnoService`](../servicios/alumnoservice.md) para su tratamiento y posterior almacenamiento, tanto  asi como administrar las vistas.
