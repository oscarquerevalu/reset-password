package com.memorynotfound.spring.security.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.memorynotfound.spring.security.model.Alumno;
import com.memorynotfound.spring.security.model.Clase;
import com.memorynotfound.spring.security.model.ClaseAlumno;
import com.memorynotfound.spring.security.service.AlumnoService;
import com.memorynotfound.spring.security.service.ClaseAlumnoService;
import com.memorynotfound.spring.security.service.PersonaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/alumno")
@Api(value="Controlador para Alumnos", description="Operaciones de carga de datos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;
    
    @Autowired
    private ClaseAlumnoService claseAlumnoService;
    
    @Autowired
    private PersonaService personaService;

    @GetMapping(value="/listAlumnos", produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ver lista los alumnos ")
    public List<Alumno> listaClase(Model model) {
    	
    	List<Clase> lista = new ArrayList<Clase>();
    	List<Alumno> listaAlumnos = new ArrayList<Alumno>();
    	try {
    		listaAlumnos = alumnoService.findByAll();
    		for (Alumno alumno : listaAlumnos) {
    			alumno.setPersonas(null);
    			alumno.setClases(null);
    			alumno.setApoderados(null);
    			alumno.setPersona(personaService.findByIdAlumno(alumno.getId()));
    			
//    			alumno.getPersona().setName("ABC");
//    			personaService.guardarPersona(alumno.getPersona());
			} 
//    		listaAlumnos = lista.get(0).getAlumnos();
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
        return listaAlumnos;
    }
    
    
    @GetMapping(value = "/listalumnos/{fecha}", produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ver los alumnos por fecha de clase")
    public List<Alumno> listalumnosxFecna( @ApiParam(value = "Fecha de clase", required = true) @PathVariable String fecha) {

    	List<Alumno> listaAlumnos = new ArrayList<Alumno>();
    	List<ClaseAlumno> listaClaseAlumno = new ArrayList<ClaseAlumno>();
    	
    	try {
    		listaAlumnos = alumnoService.findByAll();
    		for (Alumno alumno : listaAlumnos) {
    			alumno.setPersonas(null);
    			alumno.setClases(null);
    			alumno.setApoderados(null);
    			alumno.setPersona(personaService.findByIdAlumno(alumno.getId()));
    			System.out.println("fecha: "+fecha);
    			
    			//Buscar si se encuentra calificado
    			listaClaseAlumno = new ArrayList<ClaseAlumno>();
    			listaClaseAlumno = claseAlumnoService.findByFecha(fecha);
    			if(listaClaseAlumno!=null && listaClaseAlumno.size()>0)
    				alumno.setCalificado("SI");
    			else
    				alumno.setCalificado("NO");
			} 
//    		listaAlumnos = lista.get(0).getAlumnos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listaAlumnos;
    }
    
	
}
