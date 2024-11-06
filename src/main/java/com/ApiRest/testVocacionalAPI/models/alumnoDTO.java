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
