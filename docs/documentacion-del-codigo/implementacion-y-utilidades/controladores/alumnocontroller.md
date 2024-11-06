---
description: Controlador AlumnoController
icon: java
---

# AlumnoController

El `alumnoController` es un controlador de Spring MVC que gestiona las interacciones relacionadas con los alumnos en una aplicación. Este controlador utiliza varios métodos HTTP para manejar las solicitudes y respuestas del cliente. A continuación, se describe cada función:

* **mostrarFormulario()**: Utiliza una solicitud `GET` para mostrar un formulario donde se puede ingresar la información de un nuevo alumno. Asocia un objeto vacío `alumnoDTO` al modelo para ser utilizado en la vista de formulario.
* **recibirAlumno()**: Emplea una solicitud `POST` para recibir y guardar un nuevo alumno. Usa el servicio `alumnoService` para almacenar los datos e informa al cliente sobre el éxito o fallo de la operación mediante un `ResponseEntity`.
* **mostrarTablaAlumnos()**: Implementa una solicitud `GET` para mostrar una tabla que contiene todos los alumnos registrados. Los datos se obtienen a través del servicio `alumnoService` y se pasan al modelo para su visualización.
* **exportarTodosDatos()**: Maneja una solicitud `GET` para exportar los datos de la tabla de alumnos a un archivo Excel. El archivo se genera y se envía al cliente como un adjunto de descarga.
* **mostrarModificacionRegistro()**: Realiza una solicitud `GET` para mostrar un formulario de edición para un alumno específico basado en su ID. Recupera los datos del alumno y los convierte en un DTO para editarlos.
* **actualizarAlumno()**: Usa una solicitud `POST` para aceptar los cambios en un alumno existente. Valida los datos del formulario y, si no hay errores, actualiza los datos del alumno usando el servicio.
* **eliminarAlumno()**: Ejecuta una solicitud `POST` para eliminar un alumno seleccionado por su ID. Realiza la eliminación a través del servicio y redirige a la lista de alumnos después del proceso.

```java
package com.ApiRest.testVocacionalAPI.controllers;
import com.ApiRest.testVocacionalAPI.models.alumnoDTO;
import com.ApiRest.testVocacionalAPI.models.alumnoModel;
import com.ApiRest.testVocacionalAPI.services.alumnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class alumnoController {

    @Autowired
    alumnoService servicio; // Inyección de dependencia del servicio para acceder a la lógica de negocio.

    // Muestra el formulario para ingresar un nuevo alumno.
    @GetMapping("/test")
    public String mostrarFormulario(Model model) {
        alumnoDTO alumnodto = new alumnoDTO();
        model.addAttribute("alumnoDTO", alumnodto); // Se agrega un objeto DTO vacío al modelo.
        return "formularioTEST"; // Retorna la vista para el formulario.
    }

    // Recibe los datos del alumno desde el formulario y guarda el alumno.
    @PostMapping("/test")
    public ResponseEntity<Map<String, String>> recibirAlumno(@RequestBody alumnoDTO alumnoDTO) {
        Map<String, String> response = new HashMap<>();
        try {
            servicio.saveAlumno(alumnoDTO); // Guarda el alumno usando el servicio.
            response.put("message", "Alumno guardado exitosamente");
            return ResponseEntity.ok(response); // Respuesta exitosa.
        } catch (Exception e) {
            response.put("message", "Error al guardar el alumno");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // Respuesta con error.
        }
    }

    // Muestra la tabla de todos los alumnos.
    @GetMapping("tablaAlumnos")
    public String mostrarTablaAlumnos(Model model) {
        List<alumnoModel> alumnos = servicio.devolverAlumnos(); // Obtiene todos los alumnos.
        model.addAttribute("alumnos", alumnos); // Agrega la lista de alumnos al modelo.
        return "tablaAlumnos"; // Retorna la vista de la tabla de alumnos.
    }

    // Exporta los datos de los alumnos a un archivo Excel.
    @GetMapping("tablaAlumnos/exportar")
    public ResponseEntity<InputStreamResource> exportarTodosDatos() {
        ByteArrayInputStream stream = servicio.exportarDatos(); // Obtiene el archivo Excel con los datos.
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Disposition", "attachment; filename=alumnos.xlsx"); // Define el nombre del archivo descargable.
        return ResponseEntity.ok().headers(header).body(new InputStreamResource(stream)); // Retorna el archivo como un flujo de datos.
    }

    // Muestra el formulario para editar un alumno específico.
    @GetMapping("tablaAlumnos/edit/{id}")
    public String mostrarModificacionRegistro(Model model, @PathVariable int id) {
        try {
            alumnoModel alumno = servicio.retornarAlumno(id); // Obtiene el alumno por ID.
            model.addAttribute("alumno", alumno);

            alumnoDTO alumnoDTO = servicio.ModelToDTO(alumno); // Convierte el modelo de alumno a DTO para editar.
            model.addAttribute("alumnoDTO", alumnoDTO);
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
            return "redirect:/tablaAlumnos"; // Si hay error, redirige a la lista de alumnos.
        }
        return "productos/editarRegistro"; // Retorna la vista para editar el registro.
    }

    // Actualiza los datos del alumno luego de la modificación.
    @PostMapping("tablaAlumnos/edit/{id}")
    public String actualizarAlumno(Model model, @PathVariable int id, @Valid @ModelAttribute alumnoDTO alumnoDTO, BindingResult result) {
        try {
            alumnoModel alumno = servicio.retornarAlumno(id); // Obtiene el alumno por ID.
            model.addAttribute("alumno", alumno);

            if (result.hasErrors()) {
                return "tablaAlumnos/editarRegistro"; // Si hay errores en el formulario, vuelve a la vista de edición.
            }

            alumno = servicio.DTOtoModel(alumnoDTO); // Convierte el DTO a modelo de alumno.
            servicio.guardarRegistro(alumno); // Guarda o actualiza el alumno.
        } catch (RuntimeException e) {
            throw new RuntimeException(e); // Manejo de excepciones.
        }
        return "redirect:/tablaAlumnos"; // Redirige a la lista de alumnos después de la actualización.
    }

    // Elimina un alumno por su ID.
    @PostMapping("tablaAlumnos/delete/{id}")
    public String eliminarAlumno(@PathVariable int id) {
        try {
            alumnoModel alumno = servicio.retornarAlumno(id); // Obtiene el alumno por ID.
            servicio.eliminarRegistro(alumno); // Elimina el alumno.
        } catch (Exception e) {
            System.out.println("Error al eliminar registro: " + e.getMessage());
        }
        return "redirect:/tablaAlumnos"; // Redirige a la lista de alumnos después de eliminar.
    }
}

```
