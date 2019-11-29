package com.memorynotfound.spring.security.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.memorynotfound.spring.security.model.Alumno;
import com.memorynotfound.spring.security.model.Clase;
import com.memorynotfound.spring.security.model.ClaseAlumno;
import com.memorynotfound.spring.security.model.ClaseAlumnoActividades;
import com.memorynotfound.spring.security.model.Persona;
import com.memorynotfound.spring.security.service.AlumnoService;
import com.memorynotfound.spring.security.service.ClaseAlumnoActividadesService;
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
    private ClaseAlumnoActividadesService claseAlumnoActividadesService;
    
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
    			listaClaseAlumno = claseAlumnoService.findByFechaIdAlumno(fecha,alumno.getId());
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
    
    @GetMapping(value = "/getalumno/{fecha}/{clase}/{alumno}", produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ver los alumnos por fecha de clase")
    public Map<String, Object> alumnoxFecna( @ApiParam(value = "Fecha de clase", required = true) @PathVariable String fecha,
    										 @ApiParam(value = "Codigo de clase", required = true) @PathVariable Long clase,
    										 @ApiParam(value = "Codigo de alumno", required = true) @PathVariable Long alumno) {

    	List<Alumno> listaAlumnos = new ArrayList<Alumno>();
    	List<ClaseAlumno> listaClaseAlumno = new ArrayList<ClaseAlumno>();
    	List<ClaseAlumnoActividades> lstClaseAlumnoActividades = new ArrayList<ClaseAlumnoActividades>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	try {
    		
    		listaClaseAlumno = new ArrayList<ClaseAlumno>();
			listaClaseAlumno = claseAlumnoService.findByFechaIdAlumno(fecha,alumno);
			
			Double rec1 = new Double("0");
			Double rec2 = new Double("0");
			Double rec3 = new Double("0");
			Double rec4 = new Double("0");
			Long rc1 = 0L;
			Long rc2 = 0L;
			Long rc3 = 0L;
			Long rc4 = 0L;
			
			for (ClaseAlumno claseAlumno : listaClaseAlumno) {
				lstClaseAlumnoActividades = claseAlumnoActividadesService.findByIdClasealumno(claseAlumno.getId());
				
				for (ClaseAlumnoActividades claseAlumnoActividades : lstClaseAlumnoActividades) {
					if(rec1.equals(new Double("0"))) {
						rec1 = claseAlumnoActividades.getValor() != null && !claseAlumnoActividades.getValor().equals(new Double("0"))? claseAlumnoActividades.getValor():new Double("0");
						rc1 = claseAlumnoActividades.getId_recurso();
					}else if(rec2.equals(new Double("0"))) {
						rec2 = claseAlumnoActividades.getValor() != null && !claseAlumnoActividades.getValor().equals(new Double("0"))? claseAlumnoActividades.getValor():new Double("0");
						rc2 = claseAlumnoActividades.getId_recurso();
					}else if(rec3.equals(new Double("0"))) {
						rec3 = claseAlumnoActividades.getValor() != null && !claseAlumnoActividades.getValor().equals(new Double("0"))? claseAlumnoActividades.getValor():new Double("0");
						rc3 = claseAlumnoActividades.getId_recurso();
					}else if(rec4.equals(new Double("0"))) {
						rec4 = claseAlumnoActividades.getValor() != null && !claseAlumnoActividades.getValor().equals(new Double("0"))? claseAlumnoActividades.getValor():new Double("0");
						rc4 = claseAlumnoActividades.getId_recurso();
					}else {
						break;
					}
				}
			}
			
			map.put("rec1", rc1);
			map.put("val1", rec1);
			map.put("rec2", rc2);
			map.put("val2", rec2);
			map.put("rec3", rc3);
			map.put("val3", rec3);
			map.put("rec4", rc4);
			map.put("val4", rec4);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;
    }
    
    @ApiOperation(value = "Graba datos de clase")
    @PostMapping("/grabarClase")
    public String create(@RequestBody Map<String, String> body){
    	
    	ClaseAlumno claseAlumno = new ClaseAlumno();
    	claseAlumno.setFecha(body.get("fecha"));
    	claseAlumno.setId_alumno(new Long(body.get("idAlumno")));
    	claseAlumno.setId_clase(new Long("1"));
    	ClaseAlumno claseAlumnoResp= claseAlumnoService.guardar(claseAlumno);
    	
    	String[] recursos = body.get("recursos").split(",");
    	String[] valores = body.get("valores").split(",");
    	
    	for (int i = 0; i < recursos.length; i++) {
    		String rec = recursos[i];
    		ClaseAlumnoActividades claseAlumnoActividades = new ClaseAlumnoActividades();
    		claseAlumnoActividades.setId_actividad(new Long(body.get("actividad")));
    		claseAlumnoActividades.setId_clasealumno(claseAlumnoResp.getId());
    		claseAlumnoActividades.setId_recurso(new Long(rec));
    		claseAlumnoActividades.setValor((new Double(valores[i]))/100);
    		claseAlumnoActividadesService.guardarActividad(claseAlumnoActividades);
		}
    	return "";
    }
    
    @GetMapping(value="/promRecursos", produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ver promedio de recursos ")
    public List<Map<String, Object>>  promRecursos(Model model) {
    	
    	List<Map<String, Object>> listReturn = new ArrayList<Map<String,Object>>(); 
    	Map<String, Object> promedio = new HashMap<String, Object>();
    	List<ClaseAlumnoActividades> claseAlumnoActividades = new ArrayList<ClaseAlumnoActividades>();
    	try {
    		claseAlumnoActividades = claseAlumnoActividadesService.findAll();
    		Collections.sort(claseAlumnoActividades, ClaseAlumnoActividades.claseAlumnoActividadesComparator);
    		
    		Long id_recurso = 0L;
    		Double sum = new Double(0);
    		int cant = 0;
    		for (ClaseAlumnoActividades actividad : claseAlumnoActividades) {
    			
    			if(id_recurso.equals(0L)) {
    				id_recurso = actividad.getId_recurso();
    			}
    			
    			if(id_recurso.compareTo(actividad.getId_recurso()) == 0) {
    				cant++;
    				sum += actividad.getValor()!=null?actividad.getValor():new Double(0);
    			}else {
    				Double prom = !sum.equals(new Double(0)) && cant != 0? sum/cant:0;
    				promedio = new HashMap<String, Object>();
    				promedio.put("index", id_recurso);
    				promedio.put("value", prom);
    				listReturn.add(promedio);
    				id_recurso = actividad.getId_recurso();
    				cant=1;
    				sum = actividad.getValor()!=null?actividad.getValor():new Double(0);
    			}
			} 
    		
    		if(cant==1) {
    			Double prom = !sum.equals(new Double(0)) && cant != 0? sum/cant:0;
				promedio.put("index", id_recurso);
				promedio.put("value", prom);
				listReturn.add(promedio);
    		}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
        return listReturn;
    }
    
	
}
