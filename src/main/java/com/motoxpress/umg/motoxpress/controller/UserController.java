package com.motoxpress.umg.motoxpress.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motoxpress.umg.motoxpress.model.BaseResponse;
import com.motoxpress.umg.motoxpress.service.PersonaService;
import com.motoxpress.umg.motoxpress.service.RolService;
import com.motoxpress.umg.motoxpress.service.UserService;

@RestController
@RequestMapping("/api/proyecto/user")
@CrossOrigin
public class UserController {
@Autowired
    private UserService service;
    @Autowired
    private RolService serviceRol;
    @Autowired
    private PersonaService servicePersona;

    @GetMapping("admin/see")
    public ResponseEntity<BaseResponse> getDataList() {
        return ResponseEntity.ok(BaseResponse.builder().code("200").message("Inicio Correctamente")
                    .entity(service.getDataList()).build());
    }
}
