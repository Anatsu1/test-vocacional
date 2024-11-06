---
description: Modelo AlumnoDTO
icon: java
---

# AlumnoDTO

La clase `alumnoDTO` es un modelo de datos en Java diseñado para encapsular información relevante sobre un alumno, en el contexto de una API. El término `DTO` significa "Data Transfer Object", lo cual significa que esta clase se utiliza principalmente para transferir datos entre distintas capas de una aplicación. Al seguir las convenciones estándar de Java para DTOs, esta clase promueve la claridad y el mantenimiento del código.

Los datos de nuestro alumno seran registrados mediante el uso y ejecuccion del test vocacional, por lo que seran recibidos estos datos mediante nuestro DTO para luego ser mapeados más adelante sobre un [AlumnoModel](alumnomodel.md) y registrado en nuestra base de datos.

#### Atributos de la clase

* **nombre**: Un `String` que contiene el nombre del alumno. Es accesible y modificable mediante los métodos `getNombre` y `setNombre`.
* **apellido**: Un `String` que representa el apellido del alumno. Se puede acceder a él y modificarlo utilizando `getApellido` y `setApellido`.
* **telefono**: Un `String` que almacena el número de teléfono del alumno. Se proporcionan métodos `getTelefono` y `setTelefono` para su acceso y modificación.
* **mail**: Este atributo de tipo `String` guarda la dirección de correo electrónico del alumno. Al igual que los anteriores, tiene métodos `getMail` y `setMail` para su manejo.
* **areaRecomendada**: Un `String` que sugiere un área de especialización recomendada para el alumno, posiblemente como resultado de un análisis vocacional. Se gestiona con los métodos `getAreaRecomendada` y `setAreaRecomendada`.

```java
package com.ApiRest.testVocacionalAPI.models;
//Este código define un DTO para transferir información del alumno sin involucrar la entidad completa de la base de datos
public class alumnoDTO {
    private String nombre;
    private String apellido;
    private String telefono;
    private String mail;
    private String areaRecomendada;

    // Métodos getter y setter para cada atributo.
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
