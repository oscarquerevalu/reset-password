package com.memorynotfound.spring.security.service;

import java.util.List;

import com.memorynotfound.spring.security.model.ClaseAlumnoActividades;

public interface ClaseAlumnoActividadesService {

	void guardarActividad(ClaseAlumnoActividades c);
	List<ClaseAlumnoActividades> findAll();
	List<ClaseAlumnoActividades> findByIdClasealumno(Long idClasealumno);
}
