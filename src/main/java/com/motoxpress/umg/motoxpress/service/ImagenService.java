
    
package com.motoxpress.umg.motoxpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motoxpress.umg.motoxpress.model.entity.ImagenEntity;
import com.motoxpress.umg.motoxpress.model.repository.ImagenRepository;


import org.springframework.beans.factory.annotation.Autowired;
import com.motoxpress.umg.motoxpress.model.repository.PagoRepository;

public class ImagenService implements ServiceCRUD<ImagenEntity>{

    @Autowired
    private PagoRepository repository;

    @Override
    public ImagenEntity createOrUpdate(ImagenEntity value) {
        if (value.getId() != null) {
            ImagenEntity personaEntity = getFindUncle(value.getId());
            value.setFechaCreacion(personaEntity.getFechaCreacion());
            value.setUsuarioCreo(personaEntity.getUsuarioCreo());
        }
        return repository.save(value);

    }

    @Override
    public List<ImagenEntity> getDataList() {
        return (List<ImagenEntity>) repository.findAll();
    }

    @Override
    public ImagenEntity getFindUncle(Long value) {
       Optional<ImagenEntity> res = repository.findById(value);
        return res.isPresent() ? res.get() : null;

    }

    @Override
    public void deleteFind(ImagenEntity value) {
        repository.delete(value);
    }

}
