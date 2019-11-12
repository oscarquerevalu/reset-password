package com.memorynotfound.spring.security.service;

import java.util.List;

import com.memorynotfound.spring.security.model.ClaseAlumno;

public interface ClaseAlumnoService {

    List<ClaseAlumno> findByAll();
    List<ClaseAlumno> findByFechaIdAlumno(String fecha, Long idAlumno);
    ClaseAlumno guardar(ClaseAlumno claseAlumno);

}
