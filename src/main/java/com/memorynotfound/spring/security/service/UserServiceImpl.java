package com.memorynotfound.spring.security.service;

import com.memorynotfound.spring.security.model.UserInfo;
import com.memorynotfound.spring.security.repository.UserRepository;
import com.memorynotfound.spring.security.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.management.relation.Role;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserInfo findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public UserInfo save(UserInfo registration){
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail(registration.getEmail());
        userInfo.setUsername(registration.getEmail());
        userInfo.setRole(UserInfo.Role.ROLE_USER);
        userInfo.setName(registration.getName());
        userInfo.setTelefono(registration.getTelefono());
        userInfo.setDocumento(registration.getDocumento());
        userInfo.setPassword(passwordEncoder.encode(registration.getPassword()));
        return userRepository.save(userInfo);
    }

    @Override
    public void updatePassword(String password, Long userId) {
        userRepository.updatePassword(password, userId);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserInfo userInfo = userRepository.findByEmail(email);
        if (userInfo == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(userInfo.getEmail(),
        		userInfo.getPassword(),
                mapRolesToAuthorities(Arrays.asList(userInfo.getRole())));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<com.memorynotfound.spring.security.model.UserInfo.Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.toString()))
                .collect(Collectors.toList());
    }
}
