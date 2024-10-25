
    
package com.motoxpress.umg.motoxpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.motoxpress.umg.motoxpress.model.entity.InventarioEntity;

import com.motoxpress.umg.motoxpress.model.repository.InventarioRepository;



public class InventarioService implements ServiceCRUD<InventarioEntity>{

    @Autowired
    private InventarioRepository repository;

    @Override
    public InventarioEntity createOrUpdate(InventarioEntity value) {
        if (value.getId() != null) {
            InventarioEntity personaEntity = getFindUncle(value.getId());
            value.setFechaCreacion(personaEntity.getFechaCreacion());
            value.setUsuarioCreo(personaEntity.getUsuarioCreo());
        }
        return repository.save(value);

    }

    @Override
    public List<InventarioEntity> getDataList() {
        return (List<InventarioEntity>) repository.findAll();
    }

    @Override
    public InventarioEntity getFindUncle(Long value) {
       Optional<InventarioEntity> res = repository.findById(value);
        return res.isPresent() ? res.get() : null;

    }

    @Override
    public void deleteFind(InventarioEntity value) {
        repository.delete(value);
    }

}
