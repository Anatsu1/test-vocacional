---
description: Modelo AlumnoModel
icon: java
---

# AlumnoModel

### Descripción del Código

El código define un modelo de entidad en Java DAO (Data Access Object) utilizando JPA (Jakarta Persistence API) que corresponde a la tabla "alumnos" en una base de datos relacional. La clase `alumnoModel` está anotada con `@Entity` y `@Table`, indicando que es un objeto de persistencia relacionado con la tabla "alumnos", cada uno de sus atributos será mapeado en la base de datos como columnas correspondientes a la tabla "alumnos".

#### Atributos

* `idALumno`: Un `Int` es la clave primaria del modelo, denotada con `@Id`.
* `nombre`: Un `String` que almacena el nombre del alumno.
* `apellido`: Un `String` que almacena el apellido del alumno.
* `telefono`: Un `String` que guarda el número de teléfono del alumno.
* `mail`: Un `String` que contiene la dirección de correo electrónico del alumno.
* `areaRecomendada`: Un `String` que inicialmente tiene el valor "vacio" y representa la área recomendada para el alumno al finalizar el test.

#### Métodos

La clase proporciona métodos getter y setter para cada atributo, permitiendo su acceso y modificación.

{% code fullWidth="false" %}
```java
package com.ApiRest.testVocacionalAPI.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumnos") // La tabla en la base de datos a la que se mapea esta entidad.
public class alumnoModel {

    @Id // Define la clave primaria de la entidad.
    private int idALumno;
    private String nombre;
    private String apellido;
    private String telefono;
    private String mail;
    private String areaRecomendada = "vacio"; // Valor por defecto para el área recomendada.

    // Métodos getter y setter para cada atributo.
    public int getIdALumno() {
        return idALumno;
    }

    public void setIdALumno(int idALumno) {
        this.idALumno = idALumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAreaRecomendada() {
        return areaRecomendada;
    }

    public void setAreaRecomendada(String areaRecomendada) {
        this.areaRecomendada = areaRecomendada;
    }
}

```
{% endcode %}

