---
description: Repositorio iAlumnoRepository
icon: java
---

# iAlumnoRepository

El código es una interfaz de repositorio en Java para una aplicación que utiliza Spring Data JPA. La interfaz `iAlumnoRepository` extiende `JpaRepository`, lo que le permite manejar operaciones básicas de persistencia (como crear, leer, actualizar y eliminar) para la entidad `alumnoModel`. La anotación `@Repository` indica que esta interfaz es un componente de persistencia que interactúa con la base de datos. Utiliza `Integer` como tipo de dato para la clave principal de `alumnoModel`, ya que su ID es del tipo entero.

```java
package com.ApiRest.testVocacionalAPI.repositories;

import com.ApiRest.testVocacionalAPI.models.alumnoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Interfaz repositorio que extiende JpaRepository para realizar operaciones CRUD automáticamente.
@Repository
public interface iAlumnoRepository extends JpaRepository<alumnoModel, Integer> {
}

```
