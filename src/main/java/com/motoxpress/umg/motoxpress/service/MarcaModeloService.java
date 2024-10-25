
    
package com.motoxpress.umg.motoxpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;



import com.motoxpress.umg.motoxpress.model.entity.MarcaModeloEntity;

import com.motoxpress.umg.motoxpress.model.repository.MarcaModeloRepository;



public class MarcaModeloService implements ServiceCRUD<MarcaModeloEntity>{

    @Autowired
    private MarcaModeloRepository repository;

    @Override
    public MarcaModeloEntity createOrUpdate(MarcaModeloEntity value) {
        if (value.getId() != null) {
            MarcaModeloEntity personaEntity = getFindUncle(value.getId());
            value.setFechaCreacion(personaEntity.getFechaCreacion());
            value.setUsuarioCreo(personaEntity.getUsuarioCreo());
        }
        return repository.save(value);

    }

    @Override
    public List<MarcaModeloEntity> getDataList() {
        return (List<MarcaModeloEntity>) repository.findAll();
    }

    @Override
    public MarcaModeloEntity getFindUncle(Long value) {
       Optional<MarcaModeloEntity> res = repository.findById(value);
        return res.isPresent() ? res.get() : null;

    }

    @Override
    public void deleteFind(MarcaModeloEntity value) {
        repository.delete(value);
    }

}
