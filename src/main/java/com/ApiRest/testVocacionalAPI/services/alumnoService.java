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
    private iAlumnoRepository repo;  // Inyección de dependencia del repositorio para acceder a la base de datos.

    // Guarda un alumno en la base de datos a partir de un objeto DTO.
    public void saveAlumno(alumnoDTO alumnodto) {
        alumnoModel alumno = new alumnoModel();
        alumno.setNombre(alumnodto.getNombre());
        alumno.setApellido(alumnodto.getApellido());
        alumno.setMail(alumnodto.getMail());
        alumno.setTelefono(alumnodto.getTelefono());
        alumno.setAreaRecomendada(alumnodto.getAreaRecomendada());
        repo.save(alumno);  // Guardado del objeto alumnoModel en la base de datos.
    }

    // Devuelve una lista con todos los alumnos en la base de datos.
    public List<alumnoModel> devolverAlumnos() {
        return repo.findAll();
    }

    // Genera un archivo Excel con los datos de todos los alumnos.
    public ByteArrayInputStream exportarDatos() {
        String[] columnas = {"Nro Registro", "Nombre", "Apellido", "Telefono", "Email", "Area Recomendada"};
        Workbook workbook = new HSSFWorkbook();  // Crear libro de Excel.
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Sheet sheet = workbook.createSheet("alumnos");  // Crear hoja con nombre "alumnos".
        Row row = sheet.createRow(0);

        // Crear encabezados en la primera fila.
        for (int i = 0; i < columnas.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(columnas[i]);
        }

        // Obtener lista de alumnos y agregar cada uno a una nueva fila en la hoja.
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

        // Escribir el archivo en el flujo de salida y cerrarlo.
        try {
            workbook.write(stream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(stream.toByteArray());  // Devolver el archivo como flujo de datos.
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

    // Convierte un objeto alumnoDTO a alumnoModel.
    public alumnoModel DTOtoModel(alumnoDTO alumnoDTO) {
        alumnoModel alumno = new alumnoModel();
        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setApellido(alumnoDTO.getApellido());
        alumno.setMail(alumnoDTO.getMail());
        alumno.setTelefono(alumnoDTO.getTelefono());
        alumno.setAreaRecomendada(alumnoDTO.getAreaRecomendada());
        return alumno;
    }

    // Convierte un objeto alumnoModel a alumnoDTO.
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
