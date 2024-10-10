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
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class alumnoController {
    @Autowired
    alumnoService servicio;

    @GetMapping("/test")
    public String mostrarFormulario(Model model){
        alumnoDTO alumnodto = new alumnoDTO();
        model.addAttribute("alumnoDTO",alumnodto);
        return "formularioTEST";
    }
    @PostMapping("/test")
    public ResponseEntity<Map<String, String>> recibirAlumno(@RequestBody alumnoDTO alumnoDTO){
        Map<String, String> response = new HashMap<>();
        try {
            servicio.saveAlumno(alumnoDTO);
            response.put("message", "Alumno guardado exitosamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error al guardar el alumno");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("tablaAlumnos")
    public String mostrarTablaAlumnos(Model model){
        List<alumnoModel> alumnos = servicio.devolverAlumnos();
        model.addAttribute("alumnos",alumnos);
        return "tablaAlumnos";
    }

    @GetMapping("tablaAlumnos/exportar")
    public ResponseEntity<InputStreamResource> exportarTodosDatos() {
        ByteArrayInputStream stream = servicio.exportarDatos();
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Disposition", "attachment; filename=alumnos.xlsx");
        return ResponseEntity.ok().headers(header).body(new InputStreamResource(stream));
    }


    @GetMapping("tablaAlumnos/edit/{id}")
    public String mostrarModificacionREgistro(Model model, @PathVariable int id) {
        try {
            alumnoModel alumno = servicio.retornarAlumno(id);
            model.addAttribute("alumno", alumno);

            alumnoDTO alumnoDTO = new alumnoDTO();
            alumnoDTO = servicio.ModelToDTO(alumno);
            model.addAttribute("alumnoDTO", alumnoDTO);
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
            return "redirect:/tablaAlumnos";
        }
        return "productos/editarRegistro";  // Asegúrate que esta vista existe
    }

    @PostMapping("tablaAlumnos/edit/{id}")
    public String actualizarProducto(Model model, @PathVariable int id, @Valid @ModelAttribute alumnoDTO alumnoDTO, BindingResult result){
        try{
            alumnoModel alumno = servicio.retornarAlumno(id);
            model.addAttribute("alumno",alumno);
            if(result.hasErrors()){
                return "tablaAlumnos/editarRegistro";
            }
            alumno = servicio.DTOtoModel(alumnoDTO);
            servicio.guardarRegistro(alumno);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/tablaAlumnos";
    }
    @PostMapping("tablaAlumnos/delete/{id}")
    public String eliminarProducto(@PathVariable int id) {
        try {
            alumnoModel alumno = servicio.retornarAlumno(id);
            servicio.eliminarRegistro(alumno);
        } catch (Exception e) {
            System.out.println("Error al eliminar registro: " + e.getMessage());
        }
        return "redirect:/tablaAlumnos";
    }

}
