package com.motoxpress.umg.motoxpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.motoxpress.umg.motoxpress.model.entity.Pagos.PagoEntity;
import com.motoxpress.umg.motoxpress.model.repository.PagoRepository;

public class PagoService implements ServiceCRUD<PagoEntity>{

    @Autowired
    private PagoRepository repository;

    @Override
    public PagoEntity createOrUpdate(PagoEntity value) {
        if (value.getIdPago() != null) {
            PagoEntity personaEntity = getFindUncle(value.getIdPago());
            value.setFechaCreacion(personaEntity.getFechaCreacion());
            value.setUsuarioCreo(personaEntity.getUsuarioCreo());
        }
        return repository.save(value);

    }

    @Override
    public List<PagoEntity> getDataList() {
        return (List<PagoEntity>) repository.findAll();
    }

    @Override
    public PagoEntity getFindUncle(Long value) {
       Optional<PagoEntity> res = repository.findById(value);
        return res.isPresent() ? res.get() : null;

    }

    @Override
    public void deleteFind(PagoEntity value) {
        repository.delete(value);
    }

}
