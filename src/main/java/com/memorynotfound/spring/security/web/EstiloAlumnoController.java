package com.memorynotfound.spring.security.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memorynotfound.spring.security.model.EstiloAlumno;
import com.memorynotfound.spring.security.service.EstiloAlumnoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/estiloAlumno")
@Api(value="Controlador para Estilos de Aprendizaje por Alumnos")
public class EstiloAlumnoController {

    @Autowired
    private EstiloAlumnoService estiloAlumnoService;

    @ApiOperation(value = "Graba datos de Estilo")
    @PostMapping("/grabarEstilo")
    public String create(@RequestBody Map<String, String> body){
    	
    	EstiloAlumno estiloAlumno = new EstiloAlumno();
    	estiloAlumno.setFecha(body.get("fecha"));
    	estiloAlumno.setId_alumno(new Long(body.get("idAlumno")));
    	estiloAlumno.setId_clase(new Long("1"));
    	
    	
    	String[] recursos = body.get("recursos").split(",");
    	String[] valores = body.get("valores").split(",");
    	
    	for (int i = 0; i < recursos.length; i++) {
    		String rec = recursos[i];
    		if("1".equals(rec)) {
    			estiloAlumno.setValor1(new Double(valores[i]));
    		}else if("2".equals(rec)) {
    			estiloAlumno.setValor2(new Double(valores[i]));
    		}else if("3".equals(rec)) {
    			estiloAlumno.setValor3(new Double(valores[i]));
    		}else if("4".equals(rec)) {
    			estiloAlumno.setValor4(new Double(valores[i]));
    		}else if("5".equals(rec)) {
    			estiloAlumno.setValor5(new Double(valores[i]));
    		}else if("6".equals(rec)) {
    			estiloAlumno.setValor6(new Double(valores[i]));
    		}else if("7".equals(rec)) {
    			estiloAlumno.setValor7(new Double(valores[i]));
    		}else if("8".equals(rec)) {
    			estiloAlumno.setValor8(new Double(valores[i]));
    		}
		}
    	estiloAlumnoService.guardar(estiloAlumno);
    	return "";
    }
    
	
}
