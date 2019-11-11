package com.memorynotfound.spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memorynotfound.spring.security.model.Alumno;
import com.memorynotfound.spring.security.model.Clase;
import com.memorynotfound.spring.security.repository.AlumnoRepository;
import com.memorynotfound.spring.security.repository.ClaseRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;


	@Override
	public List<Alumno> findByAll() {
		// TODO Auto-generated method stub
		return alumnoRepository.findAll();
	}
}
