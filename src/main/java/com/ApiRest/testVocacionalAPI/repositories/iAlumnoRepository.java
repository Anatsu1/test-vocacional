package com.ApiRest.testVocacionalAPI.repositories;

import com.ApiRest.testVocacionalAPI.models.alumnoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Interfaz repositorio que extiende JpaRepository para realizar operaciones CRUD automáticamente.
@Repository
public interface iAlumnoRepository extends JpaRepository<alumnoModel, Integer> {
}
