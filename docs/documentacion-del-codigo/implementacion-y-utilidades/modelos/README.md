---
description: Modelos utilizados para el desarrollo de la aplicación
icon: box-check
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

# Modelos

La utilización es la siguiente, mediante un modelo alumnoModel, nuestro objeto DAO, tendremos accesos a nuestra tabla "alumnos" mapeando cada uno de sus atributos con una columna especifica de nuestra tabla, para conectar esos datos, primero deberemos recopilarlos, por lo que se hace uso de nuestra clase alumnoDTO con la cual obtendremos nuestros datos, encapsulandolos para luego crear nuestro registro en BD o lo que es lo mismo, una nueva instancia de alumnoModel.

En este proyecto se encuentran dos modelos que constan en una clase que representan DAO y estructuran datos utilizados en una aplicación DTO.&#x20;

Estos son:

* [`AlumnoModel`](alumnomodel.md)
* [`AlumnoDTO`](alumnodto.md)
