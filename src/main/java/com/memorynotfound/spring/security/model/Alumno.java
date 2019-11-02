package com.memorynotfound.spring.security.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Classe que representa o usuario do sistema
 * 
 * @author hlandim
 *
 */
@Entity
public class Alumno implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy="alumno")
    private List<Persona> personas;
	
	@ManyToMany(mappedBy="alumnos")
    private List<Apoderado> apoderados = new ArrayList<Apoderado>();
	
	@ManyToMany(mappedBy="alumnos")
    private List<Clase> clases = new ArrayList<Clase>();

	public Alumno() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public List<Apoderado> getApoderados() {
		return apoderados;
	}

	public void setApoderados(List<Apoderado> apoderados) {
		this.apoderados = apoderados;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	
	
}
