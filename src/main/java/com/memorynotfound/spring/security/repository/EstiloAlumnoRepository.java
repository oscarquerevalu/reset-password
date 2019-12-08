package com.memorynotfound.spring.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.memorynotfound.spring.security.model.ClaseAlumno;
import com.memorynotfound.spring.security.model.EstiloAlumno;

@Repository
public interface EstiloAlumnoRepository extends JpaRepository<EstiloAlumno, Long> {
	
	@Query("select c from EstiloAlumno c where c.id_alumno = :idAlumno and c.fecha BETWEEN :fechaIni and :fechaFin")
	List<EstiloAlumno> findByFechasIdAlumno(@Param("fechaIni") String fechaIni, @Param("fechaFin") String fechaFin, @Param("idAlumno") Long idAlumno);

}
