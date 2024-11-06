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
