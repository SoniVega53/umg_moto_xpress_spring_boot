package com.motoxpress.umg.motoxpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motoxpress.umg.motoxpress.model.auth.LoginRequest;
import com.motoxpress.umg.motoxpress.model.auth.RegisterRequest;
import com.motoxpress.umg.motoxpress.model.BaseResponse;
import com.motoxpress.umg.motoxpress.model.entity.PersonaEntity;
import com.motoxpress.umg.motoxpress.model.entity.RolEntity;
import com.motoxpress.umg.motoxpress.model.entity.UserEntity;
import com.motoxpress.umg.motoxpress.service.PersonaService;
import com.motoxpress.umg.motoxpress.service.RolService;
import com.motoxpress.umg.motoxpress.service.UserService;

@RestController
@RequestMapping("/api/proyecto/noauth")
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private UserService service;
    @Autowired
    private RolService serviceRol;
    @Autowired
    private PersonaService servicePersona;

    @PostMapping("register")
    public ResponseEntity<BaseResponse> register(@RequestBody RegisterRequest entity) {
        try {
            // defaul 2
            RolEntity rol = serviceRol.getFindUncle(entity.getRolId());
            if (rol != null) {
                entity.getUsername();
                UserEntity userExist = service.getFindUncleEntity(entity.getUsername());

                if (userExist != null) {
                    return ResponseEntity.ok(BaseResponse.builder().code("400")
                            .message("Usuario existente").build());
                } else {
                    PersonaEntity personaCreate = servicePersona.createOrUpdate(entity.getPersona());
                    if (personaCreate != null) {
                        UserEntity userCreate = service.register(entity, rol,personaCreate);
                        return ResponseEntity.ok(BaseResponse.builder()
                                .code("200")
                                .message("Se creo correctamente")
                                .entity(userCreate).build());
                    }
                }
            }

            return ResponseEntity.ok(BaseResponse.builder().code("400").message("Por favor revice sus datos").build());
        } catch (Exception e) {
            return ResponseEntity.ok(BaseResponse.builder().code("400").message(e.getMessage()).build());
        }
    }

    @PostMapping("login")
    public ResponseEntity<BaseResponse> login(@RequestBody LoginRequest request) {
        try {
            return ResponseEntity.ok(BaseResponse.builder().code("200").message("Inicio Correctamente")
                    .entity(service.login(request)).build());
        } catch (Exception e) {
            return ResponseEntity.ok(
                    BaseResponse.builder().code("400").message("Usuario no Existe o Contraseña es invalida").build());
        }
    }

   
}
