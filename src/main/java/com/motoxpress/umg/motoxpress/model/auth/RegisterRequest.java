package com.motoxpress.umg.motoxpress.model.auth;

import com.motoxpress.umg.motoxpress.model.entity.PersonaEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String username;
    String password;
    String email;
    long rolId;
    PersonaEntity persona;
}
