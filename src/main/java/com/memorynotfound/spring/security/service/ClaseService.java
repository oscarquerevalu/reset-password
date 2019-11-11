package com.memorynotfound.spring.security.service;

import com.memorynotfound.spring.security.model.Clase;
import com.memorynotfound.spring.security.model.Persona;
import com.memorynotfound.spring.security.web.dto.UserRegistrationDto;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface ClaseService {

    List<Clase> findByAll();

}
