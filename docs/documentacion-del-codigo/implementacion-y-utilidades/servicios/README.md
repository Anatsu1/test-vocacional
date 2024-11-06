---
description: Servicios accesados en la aplicacion
icon: laptop-code
cover: ../../../.gitbook/assets/1723111253880.jpg
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

# Servicios

En este proyecto de prueba vocacional, los servicios en **Java** y **Spring Boot** son fundamentales. Manejan la lógica principal del negocio, lo que hace que la aplicación sea más fácil de construir, escalar y mantener. Aquí está cómo estos servicios añaden valor específico al proyecto:

* **Modularidad**: Los servicios nos permiten separar claramente la lógica de negocio de las demás capas, como la presentación (controladores) y el acceso a datos (repositorios). Esto mejora la organización del código y facilita el mantenimiento, ya que cada capa tiene una responsabilidad definida.
* **Reusabilidad**: Centralizando la lógica de negocio en un servicio (por ejemplo, el [`alumnoServic`](alumnoservice.md)), podemos reutilizar funcionalidades clave como guardar alumnos o exportar datos en Excel. De este modo, la misma lógica puede ser llamada desde distintos controladores o componentes sin duplicación de código.
* **Mantenibilidad**: Al concentrar funciones específicas en el servicio, el código se vuelve más fácil de leer y gestionar. Si en el futuro necesitamos actualizar la manera en que se maneja la información de los alumnos, podemos hacer los cambios en un solo lugar, sin impactar el resto de la aplicación.
* **Inyección de Dependencias**: Spring Boot permite que el servicio se configure y gestione automáticamente, inyectándolo donde se necesite sin tener que instanciarlo manualmente. Esto hace que el código sea más limpio y promueve un diseño desacoplado.
