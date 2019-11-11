package com.memorynotfound.spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memorynotfound.spring.security.model.Clase;
import com.memorynotfound.spring.security.model.ClaseAlumno;
import com.memorynotfound.spring.security.repository.ClaseAlumnoRepository;
import com.memorynotfound.spring.security.repository.ClaseRepository;

@Service
public class ClaseAlumnoServiceImpl implements ClaseAlumnoService {

    @Autowired
    private ClaseAlumnoRepository claseAlumnoRepository;


	@Override
	public List<ClaseAlumno> findByAll() {
		// TODO Auto-generated method stub
		return claseAlumnoRepository.findAll();
	}
	
	@Override
	public List<ClaseAlumno> findByFecha(String fecha) {
		// TODO Auto-generated method stub
		return claseAlumnoRepository.findByFecha(fecha);
	}
}
