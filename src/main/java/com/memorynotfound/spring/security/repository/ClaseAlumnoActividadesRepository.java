package com.memorynotfound.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.memorynotfound.spring.security.model.ClaseAlumnoActividades;

@Repository
public interface ClaseAlumnoActividadesRepository extends JpaRepository<ClaseAlumnoActividades, Long> {
	
}

