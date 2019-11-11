package com.memorynotfound.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.memorynotfound.spring.security.model.Clase;
import com.memorynotfound.spring.security.model.Persona;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Long> {

//    Persona findByEmail(String email);
//
//    @Query("update Persona u set u.password = :password where u.id = :id")
//    void updatePassword(@Param("password") String password, @Param("id") Long id);
}
