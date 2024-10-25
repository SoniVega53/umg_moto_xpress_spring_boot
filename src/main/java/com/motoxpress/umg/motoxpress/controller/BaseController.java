package com.motoxpress.umg.motoxpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.motoxpress.umg.motoxpress.service.PersonaService;
import com.motoxpress.umg.motoxpress.service.RolService;
import com.motoxpress.umg.motoxpress.service.UserService;

public class BaseController {
    @Autowired
    protected UserService service;
    @Autowired
    protected RolService serviceRol;
    @Autowired
    protected PersonaService servicePersona;
    @Autowired
    protected PasswordEncoder passwordEncoder;
}
