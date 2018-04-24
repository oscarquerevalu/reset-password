package com.memorynotfound.spring.security.service;

import com.memorynotfound.spring.security.model.UserInfo;
import com.memorynotfound.spring.security.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserInfo findByEmail(String email);

    UserInfo save(UserRegistrationDto registration);

    void updatePassword(String password, Long userId);
}
