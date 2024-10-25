package com.motoxpress.umg.motoxpress.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.motoxpress.umg.motoxpress.model.entity.PersonaEntity;
import com.motoxpress.umg.motoxpress.model.entity.ReservacionEntity;
import com.motoxpress.umg.motoxpress.model.repository.ReservacionRepository;

public class ReservacionService implements ServiceCRUD<ReservacionEntity>{

    @Autowired
    private ReservacionRepository repository;

    @Override
    public ReservacionEntity createOrUpdate(ReservacionEntity value) {
        if (value.getIdReservacion() != null) {
            ReservacionEntity personaEntity = getFindUncle(value.getIdReservacion());
            value.setFechaCreacion(personaEntity.getFechaCreacion());
            value.setUsuarioCreo(personaEntity.getUsuarioCreo());
        }
        return repository.save(value);

    }

    @Override
    public List<ReservacionEntity> getDataList() {
         return (List<ReservacionEntity>) repository.findAll();
    }

    @Override
    public ReservacionEntity getFindUncle(Long value) {
       Optional<ReservacionEntity> res = repository.findById(value);
        return res.isPresent() ? res.get() : null;
    }

    @Override
    public void deleteFind(ReservacionEntity value) {
        repository.delete(value);
    }

}
