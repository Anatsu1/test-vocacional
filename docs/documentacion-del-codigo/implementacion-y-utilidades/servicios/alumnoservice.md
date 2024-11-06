---
description: Servicio AlumnoService
icon: java
---

# AlumnoService

## Funcionalidad del Servicio `alumnoService`

El servicio `alumnoService` encapsula la lógica de negocio relacionada con la gestión de alumnos en el proyecto de test vocacional. Sus principales responsabilidades son:**Conversión entre DTO y Modelo (`convertirDTOaModel` y `convertirModelaDTO`)**:

Estas funciones facilitan la transformación de datos entre `alumnoDTO` y `alumnoModel`. `convertirDTOaModel` toma la información del DTO y la transforma en un modelo que puede ser manejado por la parte lógica de la aplicación. De manera inversa, `convertirModelaDTO` se utiliza para convertir el modelo de negocio en un DTO que se puede transportar a otros servicios o capas de la aplicación.

**Eliminación y Actualización de Registros (`eliminarAlumno` y `actualizarAlumno`)**:

`eliminarAlumno` permite eliminar eficientemente un registro de alumno identificado por su ID. `actualizarAlumno` se encarga de aplicar cambios a un registro existente, asegurando que los datos se almacenen y mantengan correctamente en la base de datos.

**Consulta de Alumno Específico (`consultarAlumnoPorId`)**:

Esta función busca y recupera la información de un alumno específico a través de su ID. Es esencial para operaciones donde se necesita acceder rápidamente a los datos de un alumno individual, ya sea para visualización o modificación.

**Exportación de Datos a Excel (`exportarDatosAExcel`)**:

`exportarDatosAExcel` se encarga de generar un documento Excel que contiene la información de los alumnos. Utiliza Apache POI para estructurar y llenar las celdas, permitiendo compartir y analizar los datos de manera sencilla e interpretable.

**Consulta General de Alumnos (`obtenerTodosLosAlumnos`)**:

Esta función consulta la base de datos para compilar y retornar todos los registros de alumnos, proporcionando una perspectiva completa de los datos almacenados. Es ideal para generar reportes o para revisiones de datos en lotes.

**Guardar Alumnos (`guardarAlumno`)**:

`guardarAlumno` gestiona la conversión de un `alumnoDTO` a un `alumnoModel` y su consecuente almacenamiento en la base de datos. Utiliza `iAlumnoRepository` para asegurar que los datos sean manejados de manera eficiente, simplificando el proceso de añadir nuevos registros al sistema.

```java
package com.ApiRest.testVocacionalAPI.services;

import com.ApiRest.testVocacionalAPI.models.alumnoDTO;
import com.ApiRest.testVocacionalAPI.models.alumnoModel;
import com.ApiRest.testVocacionalAPI.repositories.iAlumnoRepository;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class alumnoService {

    @Autowired
    private iAlumnoRepository repo;  // Inyección de dependencia del repositorio para interactuar con la base de datos.

    // Guarda un alumno en la base de datos a partir de un DTO.
    public void saveAlumno(alumnoDTO alumnodto) {
        alumnoModel alumno = new alumnoModel();
        alumno.setNombre(alumnodto.getNombre());
        alumno.setApellido(alumnodto.getApellido());
        alumno.setMail(alumnodto.getMail());
        alumno.setTelefono(alumnodto.getTelefono());
        alumno.setAreaRecomendada(alumnodto.getAreaRecomendada());
        repo.save(alumno);  // Guarda el objeto alumnoModel en la base de datos.
    }

    // Devuelve todos los alumnos de la base de datos.
    public List<alumnoModel> devolverAlumnos() {
        return repo.findAll();
    }

    // Genera un archivo Excel con los datos de todos los alumnos.
    public ByteArrayInputStream exportarDatos() {
        String[] columnas = {"Nro Registro", "Nombre", "Apellido", "Telefono", "Email", "Area Recomendada"};
        Workbook workbook = new HSSFWorkbook();  // Crea un libro Excel.
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Sheet sheet = workbook.createSheet("alumnos");  // Crea una hoja de trabajo con nombre "alumnos".
        Row row = sheet.createRow(0);

        // Crea los encabezados de columna en la primera fila.
        for (int i = 0; i < columnas.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(columnas[i]);
        }

        // Añade cada alumno como una fila en la hoja de trabajo.
        List<alumnoModel> alumnos = devolverAlumnos();
        int rowInicio = 1;

        for (alumnoModel alumno : alumnos) {
            row = sheet.createRow(rowInicio);
            row.createCell(0).setCellValue(rowInicio);  // Número de registro.
            row.createCell(1).setCellValue(alumno.getNombre());
            row.createCell(2).setCellValue(alumno.getApellido());
            row.createCell(3).setCellValue(alumno.getTelefono());
            row.createCell(4).setCellValue(alumno.getMail());
            row.createCell(5).setCellValue(alumno.getAreaRecomendada());
            rowInicio++;
        }

        // Escribe el libro Excel al flujo de salida.
        try {
            workbook.write(stream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(stream.toByteArray());  // Devuelve el archivo Excel como un flujo de bytes.
    }

    // Busca y devuelve un alumno por su ID.
    public alumnoModel retornarAlumno(int id) {
        return repo.findById(id).get();
    }

    // Elimina un registro de alumno de la base de datos.
    public void eliminarRegistro(alumnoModel alumno) {
        repo.delete(alumno);
    }

    // Guarda o actualiza un registro de alumno en la base de datos.
    public void guardarRegistro(alumnoModel alumno) {
        repo.save(alumno);
    }

    // Convierte un DTO de alumno a modelo de alumno.
    public alumnoModel DTOtoModel(alumnoDTO alumnoDTO) {
        alumnoModel alumno = new alumnoModel();
        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setApellido(alumnoDTO.getApellido());
        alumno.setMail(alumnoDTO.getMail());
        alumno.setTelefono(alumnoDTO.getTelefono());
        alumno.setAreaRecomendada(alumnoDTO.getAreaRecomendada());
        return alumno;
    }

    // Convierte un modelo de alumno a DTO de alumno.
    public alumnoDTO ModelToDTO(alumnoModel alumno) {
        alumnoDTO alumnoDTO = new alumnoDTO();
        alumnoDTO.setNombre(alumno.getNombre());
        alumnoDTO.setApellido(alumno.getApellido());
        alumnoDTO.setMail(alumno.getMail());
        alumnoDTO.setTelefono(alumno.getTelefono());
        alumnoDTO.setAreaRecomendada(alumno.getAreaRecomendada());
        return alumnoDTO;
    }
}

```
