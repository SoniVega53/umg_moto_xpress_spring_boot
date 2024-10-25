package com.motoxpress.umg.motoxpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motoxpress.umg.motoxpress.model.entity.PersonaEntity;
import com.motoxpress.umg.motoxpress.model.entity.RolEntity;
import com.motoxpress.umg.motoxpress.model.repository.RolRepository;

@Service
public class RolService {
    @Autowired
    private RolRepository repository;

    public List<RolEntity> getDataList() {
        return (List<RolEntity>) repository.findAll();
    }

     public RolEntity getFindUncle(Long value) {
        Optional<RolEntity> res = repository.findById(value);
        return res.isPresent() ? res.get() : null;
    }
}
