package com.memorynotfound.spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memorynotfound.spring.security.model.Persona;
import com.memorynotfound.spring.security.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;


	@Override
	public List<Persona> findByAll() {
		// TODO Auto-generated method stub
		return personaRepository.findAll();
	}


	@Override
	public Persona findById(Long id) {
		// TODO Auto-generated method stub
		return personaRepository.getOne(id);
	}
	
	@Override
	public Persona findByIdAlumno(Long id) {
		// TODO Auto-generated method stub
		return personaRepository.findByIdAlumno(id);
	}


	@Override
	public void guardarPersona(Persona p) {
		// TODO Auto-generated method stub
		personaRepository.saveAndFlush(p);
	}
}