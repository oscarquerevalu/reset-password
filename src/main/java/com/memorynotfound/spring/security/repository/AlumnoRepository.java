package com.memorynotfound.spring.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.memorynotfound.spring.security.model.Alumno;
import com.memorynotfound.spring.security.model.Clase;
import com.memorynotfound.spring.security.model.Persona;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
	public static final String FIND_PROJECTS = "SELECT p.id FROM Alumno p";

	@Query(value = FIND_PROJECTS, nativeQuery = true)
    public List<SoloId> findAlumnos();

//    Persona findByEmail(String email);
//
//    @Query("update Persona u set u.password = :password where u.id = :id")
//    void updatePassword(@Param("password") String password, @Param("id") Long id);
}

interface SoloId {

	  String getId();
	}