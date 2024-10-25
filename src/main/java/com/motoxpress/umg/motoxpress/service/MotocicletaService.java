
    
package com.motoxpress.umg.motoxpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;




import com.motoxpress.umg.motoxpress.model.entity.MotocicletaEntity;
import com.motoxpress.umg.motoxpress.model.repository.MotocicletaRepository;



public class MotocicletaService implements ServiceCRUD<MotocicletaEntity>{

    @Autowired
    private MotocicletaRepository repository;

    @Override
    public MotocicletaEntity createOrUpdate(MotocicletaEntity value) {
        if (value.getId() != null) {
            MotocicletaEntity personaEntity = getFindUncle(value.getId());
            value.setFechaCreacion(personaEntity.getFechaCreacion());
            value.setUsuarioCreo(personaEntity.getUsuarioCreo());
        }
        return repository.save(value);

    }

    @Override
    public List<MotocicletaEntity> getDataList() {
        return (List<MotocicletaEntity>) repository.findAll();
    }

    @Override
    public MotocicletaEntity getFindUncle(Long value) {
       Optional<MotocicletaEntity> res = repository.findById(value);
        return res.isPresent() ? res.get() : null;

    }

    @Override
    public void deleteFind(MotocicletaEntity value) {
        repository.delete(value);
    }

}
