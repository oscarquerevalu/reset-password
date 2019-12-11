package com.memorynotfound.spring.security.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memorynotfound.spring.security.model.Alumno;
import com.memorynotfound.spring.security.model.ClaseAlumno;
import com.memorynotfound.spring.security.model.ClaseAlumnoActividades;
import com.memorynotfound.spring.security.model.EstiloAlumno;
import com.memorynotfound.spring.security.service.EstiloAlumnoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
    
    @GetMapping(value = "/getEstilos/{fechaIni}/{fechaFin}/{alumno}", produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ver los alumnos por fecha de clase")
    public List<Map<String, Object>> alumnoxFecna( @ApiParam(value = "Fecha de Inicio", required = true) @PathVariable String fechaIni,
    										 @ApiParam(value = "Fecha de Fin", required = true) @PathVariable String fechaFin,
    										 @ApiParam(value = "Codigo de alumno", required = true) @PathVariable Long alumno) {

    	List<EstiloAlumno> listaEstilos = new ArrayList<EstiloAlumno>();
    	List<Double> lstDataVal = new ArrayList<Double>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
    	
    	try {
    		
    		listaEstilos = estiloAlumnoService.findByFechaIdAlumno(fechaIni, fechaFin, alumno);
			
			
			for (EstiloAlumno estiloAlumno : listaEstilos) {
				map = new HashMap<String, Object>();
				lstDataVal = new ArrayList<Double>();
				lstDataVal.add(0,estiloAlumno.getValor1()!=null?estiloAlumno.getValor1():0.0);
				lstDataVal.add(1,estiloAlumno.getValor2()!=null?estiloAlumno.getValor2():0.0);
				lstDataVal.add(2,estiloAlumno.getValor3()!=null?estiloAlumno.getValor3():0.0);
				lstDataVal.add(3,estiloAlumno.getValor4()!=null?estiloAlumno.getValor4():0.0);
				lstDataVal.add(4,estiloAlumno.getValor5()!=null?estiloAlumno.getValor5():0.0);
				lstDataVal.add(5,estiloAlumno.getValor6()!=null?estiloAlumno.getValor6():0.0);
				lstDataVal.add(6,estiloAlumno.getValor7()!=null?estiloAlumno.getValor7():0.0);
				lstDataVal.add(7,estiloAlumno.getValor8()!=null?estiloAlumno.getValor8():0.0);
				map.put("data", lstDataVal);
				map.put("label", "Fecha "+estiloAlumno.getFecha().substring(0, 2)+"/"+estiloAlumno.getFecha().substring(2, 4)+"/"+estiloAlumno.getFecha().substring(4));
				map.put("lineTension", 0);
				map.put("fill", false);
				map.put("borderColor", "blue");
				lstMap.add(map);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lstMap;
    }
}
