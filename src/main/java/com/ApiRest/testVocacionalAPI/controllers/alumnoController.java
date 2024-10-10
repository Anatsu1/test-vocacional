package com.ApiRest.testVocacionalAPI.controllers;


import com.ApiRest.testVocacionalAPI.models.alumnoDTO;
import com.ApiRest.testVocacionalAPI.models.alumnoModel;
import com.ApiRest.testVocacionalAPI.services.alumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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

}
