package com.motoxpress.umg.motoxpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motoxpress.umg.motoxpress.model.BaseResponse;
import com.motoxpress.umg.motoxpress.model.auth.RegisterRequest;
import com.motoxpress.umg.motoxpress.model.entity.PersonaEntity;
import com.motoxpress.umg.motoxpress.model.entity.RolEntity;
import com.motoxpress.umg.motoxpress.model.entity.UserEntity;
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
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("admin/usuarios/list")
    public ResponseEntity<BaseResponse> getDataList() {
        return ResponseEntity.ok(BaseResponse.builder().code("200").message("Inicio Correctamente")
                .entity(service.getDataList()).build());
    }

    @GetMapping("detalle/usuario/{username}")
    public ResponseEntity<BaseResponse> getUserDetail(@PathVariable String username) {
        try {
            UserEntity userExist = service.getFindUncleEntity(username.toLowerCase());
            if (userExist != null) {
                return ResponseEntity.ok(BaseResponse.builder().code("200").message("Usuario encontrado")
                        .entity(userExist).build());
            }
            return ResponseEntity.ok(BaseResponse.builder().code("400").message("No se encontro usuario").build());
        } catch (Exception e) {
            return ResponseEntity.ok(BaseResponse.builder().code("400").message(e.getMessage()).build());
        }
    }

    @PostMapping("usuario/update/{username}")
    public ResponseEntity<BaseResponse> updateUsuario(@PathVariable String username,
            @RequestBody PersonaEntity persona) {
        try {
            UserEntity find = service.getFindUncleEntity(username.toLowerCase());
            if (find != null) {
                persona.setIdPersona(find.getPersona().getIdPersona());
                persona.setFechaCreacion(find.getPersona().getFechaCreacion());
                return ResponseEntity.ok(BaseResponse.builder().code("200").message("Se actualizo Correctamente")
                        .entity(servicePersona.createOrUpdate(persona)).build());
            }
            return ResponseEntity.ok(
                    BaseResponse.builder().code("400").message("Usuario no Existe o Contraseña es invalida").build());
        } catch (Exception e) {
            return ResponseEntity.ok(
                    BaseResponse.builder().code("400").message("Surgio Algo Inesperado").build());
        }
    }

    @PostMapping("usuario/update/password/{username}/{password}/{passwordChange}")
    public ResponseEntity<BaseResponse> updateUsuarioPassword(@PathVariable String username,@PathVariable String password,@PathVariable String passwordChange) {
        try {
            UserEntity find = service.getFindUncleEntity(username.toLowerCase());
            if (find != null) {
                if (password != null && passwordChange != null &&
                        !password.isEmpty() && !passwordChange.isEmpty()) {

                    if (checkPassword(password, find.getPassword())) {
                        service.changePassword(passwordChange, find);

                        return ResponseEntity
                                .ok(BaseResponse.builder().code("200").message("Se actualizo Correctamente")
                                        .entity(find).build());
                    }
                }
                return ResponseEntity.ok(
                        BaseResponse.builder().code("400").message("Contraseña no es valida").build());
            }
            return ResponseEntity.ok(
                    BaseResponse.builder().code("400").message("Usuario no Existe").build());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(
                    BaseResponse.builder().code("400").message("Surgio Algo Inesperado").build());
        }
    }

    @DeleteMapping("admin/usuario/eliminar/{id}")
    public ResponseEntity<BaseResponse> deleteUsuario(@PathVariable Long id) {
        try {
            UserEntity find = service.getFindUncle(id);
            if (find != null) {
                service.deleteFind(find);
                return ResponseEntity.ok(BaseResponse.builder().code("200").message("Se elimino Correctamente")
                        .entity(find).build());
            }
            return ResponseEntity.ok(
                    BaseResponse.builder().code("400").message("Usuario no Existe o Contraseña es invalida").build());
        } catch (Exception e) {

            return ResponseEntity.ok(
                    BaseResponse.builder().code("400")
                            .message("Surgio Algo Inesperado, Revise que no tenga articulos creados").build());
        }
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        try {
            return passwordEncoder.matches(rawPassword.trim(), encodedPassword);
        } catch (Exception e) {
            return false;
        }
    }

}
