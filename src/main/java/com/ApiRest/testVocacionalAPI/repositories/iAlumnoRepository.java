package com.ApiRest.testVocacionalAPI.repositories;

import com.ApiRest.testVocacionalAPI.models.alumnoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.ByteArrayInputStream;
import java.util.List;
@Repository
public interface iAlumnoRepository extends JpaRepository<alumnoModel,Integer> {
}
