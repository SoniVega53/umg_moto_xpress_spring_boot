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
@RequestMapping("/api/proyecto/user")
@CrossOrigin
public class PagoController extends BaseController{


}
