---
description: Repositorios utilizados para la aplicacion
icon: database
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

# Repositorios

Un repositorio en una aplicación de Java Spring Boot se utiliza para gestionar eficientemente las operaciones de acceso a datos, sirviendo como una capa intermedia entre la lógica de negocio y la base de datos.  Con Spring Boot, los repositorios se implementan a menudo utilizando interfaces como `CrudRepository` o `JpaRepository`, que proporcionan métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar) de forma sencilla. En nuestro sencillo caso, utilizaremos la implementacion de [`IAlumnoRepository`](ialumnorepository.md) como formato para extender de `JpaRepository` obteniendo asi sus metodos heredados.
