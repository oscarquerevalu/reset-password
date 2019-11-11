package com.memorynotfound.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memorynotfound.spring.security.model.ClaseAlumnoActividades;
import com.memorynotfound.spring.security.repository.ClaseAlumnoActividadesRepository;

@Service
public class ClaseAlumnoActividadesServiceImpl implements ClaseAlumnoActividadesService {

    @Autowired
    private ClaseAlumnoActividadesRepository claseAlumnoActividadesRepository;

	@Override
	public void guardarActividad(ClaseAlumnoActividades c) {
		// TODO Auto-generated method stub
		claseAlumnoActividadesRepository.saveAndFlush(c);
	}

}
