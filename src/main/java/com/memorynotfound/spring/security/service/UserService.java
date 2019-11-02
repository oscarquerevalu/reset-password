package com.memorynotfound.spring.security.service;

import com.memorynotfound.spring.security.model.Persona;
import com.memorynotfound.spring.security.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    Persona findByEmail(String email);

    Persona save(Persona registration);

    void updatePassword(String password, Long userId);
}
