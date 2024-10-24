package com.motoxpress.umg.motoxpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.motoxpress.umg.motoxpress.jwt_token.JwtService;
import com.motoxpress.umg.motoxpress.model.RoleUser;
import com.motoxpress.umg.motoxpress.model.auth.AuthResponse;
import com.motoxpress.umg.motoxpress.model.auth.LoginRequest;
import com.motoxpress.umg.motoxpress.model.auth.RegisterRequest;
import com.motoxpress.umg.motoxpress.model.entity.PersonaEntity;
import com.motoxpress.umg.motoxpress.model.entity.RolEntity;
import com.motoxpress.umg.motoxpress.model.entity.UserEntity;
import com.motoxpress.umg.motoxpress.model.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
public class UserService implements ServiceCRUD<UserEntity> {
    @Autowired
    private UserRepository repository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public UserEntity createOrUpdate(UserEntity value) {
        return repository.save(value);
    }

    public List<UserEntity> getDataList() {
        return (List<UserEntity>) repository.findAll();
    }

    public UserEntity getFindUncle(Long value) {
        Optional<UserEntity> res = repository.findById(value);
        return res.isPresent() ? res.get() : null;
    }

    public UserEntity getFindUncleEntity(String value) {
        Optional<UserEntity> user = repository.findByUsername(value);
        return user.isPresent() ? user.get() : null;
    }

    public UserDetails getFindUncle(String value) {
        UserDetails user = repository.findByUsername(value).orElseThrow();
        return user;
    }

    public void deleteFind(UserEntity value) {
        repository.delete(value);
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
                UserEntity user = repository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();

    }

    public UserDetails obtenerUser(String toke) {
        UserDetails user = repository.findByUsername(jwtService.getUsernameFromToken(toke)).orElseThrow();
        return user;
    }

    public UserEntity register(RegisterRequest request,RolEntity rol,PersonaEntity personaEntity) {
        UserEntity user = UserEntity.builder()
                .username(request.getUsername())
                .correo(request.getEmail())
                .persona(personaEntity)
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(rol)
                .build();

        return repository.save(user);
    }

}
