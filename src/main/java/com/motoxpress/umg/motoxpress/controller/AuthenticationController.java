package com.motoxpress.umg.motoxpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motoxpress.umg.motoxpress.model.auth.LoginRequest;
import com.motoxpress.umg.motoxpress.model.auth.RegisterRequest;
import com.motoxpress.umg.motoxpress.model.BaseResponse;
import com.motoxpress.umg.motoxpress.model.entity.UserEntity;
import com.motoxpress.umg.motoxpress.service.UserService;

@RestController
@RequestMapping("/api/proyecto/noauth")
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private UserService service;

    @PostMapping("register")
    public ResponseEntity<BaseResponse> register(@RequestBody RegisterRequest entity) {
        try {
           
            UserEntity userCreate = service.register(entity);
            System.out.println(userCreate);
            if (userCreate != null) {
                return ResponseEntity.ok(BaseResponse.builder()
                        .code("200")
                        .message("Se creo correctamente")
                        .entity(userCreate).build());
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
            return ResponseEntity.ok(BaseResponse.builder().code("400").message("Usuario no Existe o Contraseña es invalida").build());
        }
    }

    @GetMapping("see")
    public List<UserEntity> getDataList() {
        System.out.println(service.getDataList());
        return service.getDataList();
    }
}
