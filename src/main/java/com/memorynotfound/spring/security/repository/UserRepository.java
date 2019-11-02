package com.memorynotfound.spring.security.repository;

import com.memorynotfound.spring.security.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Persona, Long> {

    Persona findByEmail(String email);

    @Modifying(clearAutomatically = true)
    @Query("update Persona u set u.password = :password where u.id = :id")
    void updatePassword(@Param("password") String password, @Param("id") Long id);
}
