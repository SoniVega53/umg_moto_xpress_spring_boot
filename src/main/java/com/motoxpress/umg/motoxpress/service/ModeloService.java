
    
package com.motoxpress.umg.motoxpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;




import com.motoxpress.umg.motoxpress.model.entity.ModeloEntity;
import com.motoxpress.umg.motoxpress.model.repository.ModeloRepository;



public class ModeloService implements ServiceCRUD<ModeloEntity>{

    @Autowired
    private ModeloRepository repository;

    @Override
    public ModeloEntity createOrUpdate(ModeloEntity value) {
        if (value.getId() != null) {
            ModeloEntity personaEntity = getFindUncle(value.getId());
            value.setFechaCreacion(personaEntity.getFechaCreacion());
            value.setUsuarioCreo(personaEntity.getUsuarioCreo());
        }
        return repository.save(value);

    }

    @Override
    public List<ModeloEntity> getDataList() {
        return (List<ModeloEntity>) repository.findAll();
    }

    @Override
    public ModeloEntity getFindUncle(Long value) {
       Optional<ModeloEntity> res = repository.findById(value);
        return res.isPresent() ? res.get() : null;

    }

    @Override
    public void deleteFind(ModeloEntity value) {
        repository.delete(value);
    }

}
