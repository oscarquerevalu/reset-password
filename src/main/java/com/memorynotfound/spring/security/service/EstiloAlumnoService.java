package com.memorynotfound.spring.security.service;

import java.util.List;

import com.memorynotfound.spring.security.model.EstiloAlumno;

public interface EstiloAlumnoService {

    List<EstiloAlumno> findByAll();
    EstiloAlumno guardar(EstiloAlumno estiloAlumno);
    List<EstiloAlumno> findByFechaIdAlumno(String fechaIni, String fechaFin, Long idAlumno);

}
