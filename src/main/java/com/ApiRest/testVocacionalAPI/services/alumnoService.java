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
import java.util.ArrayList;
import java.util.List;

@Service
public class alumnoService {
    @Autowired
    private iAlumnoRepository repo;

    public void saveAlumno(alumnoDTO alumnodto){
        alumnoModel alumno = new alumnoModel();
        alumno.setNombre(alumnodto.getNombre());
        alumno.setApellido(alumnodto.getApellido());
        alumno.setMail(alumnodto.getMail());
        alumno.setTelefono(alumnodto.getTelefono());
        alumno.setAreaRecomendada(alumnodto.getAreaRecomendada());
        repo.save(alumno);
    }

    public List<alumnoModel> devolverAlumnos(){
        return repo.findAll();
    }

    public ByteArrayInputStream exportarDatos() {
        String[] columnas = {"Nro Regitro","Nombre", "Apellido", "Telefono", "Email", "Area Recomendada"};
        Workbook workbook = new HSSFWorkbook();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Sheet sheet = workbook.createSheet("alumnos");
        Row row = sheet.createRow(0);

        for (int i = 0; i < columnas.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(columnas[i]);
        }

        List<alumnoModel> alumnos = devolverAlumnos();
        int rowInicio = 1;

        for (alumnoModel alumno : alumnos) {
            row = sheet.createRow(rowInicio);
            row.createCell(0).setCellValue(rowInicio);
            row.createCell(1).setCellValue(alumno.getNombre());
            row.createCell(2).setCellValue(alumno.getApellido());
            row.createCell(3).setCellValue(alumno.getTelefono());
            row.createCell(4).setCellValue(alumno.getMail());
            row.createCell(5).setCellValue(alumno.getAreaRecomendada());
            rowInicio++;
        }

        try {
            workbook.write(stream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(stream.toByteArray());
    }
}
