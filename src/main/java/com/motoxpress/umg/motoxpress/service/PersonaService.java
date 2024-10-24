package com.motoxpress.umg.motoxpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motoxpress.umg.motoxpress.model.entity.PersonaEntity;
import com.motoxpress.umg.motoxpress.model.repository.PersonaRepository;

@Service
public class PersonaService implements ServiceCRUD<PersonaEntity> {

    @Autowired
    private PersonaRepository repository;

    @Override
    public PersonaEntity createOrUpdate(PersonaEntity value) {
        return repository.save(value);
    }

    @Override
    public List<PersonaEntity> getDataList() {
         return (List<PersonaEntity>) repository.findAll();
    }

    @Override
    public PersonaEntity getFindUncle(Long value) {
        Optional<PersonaEntity> res = repository.findById(value);
        return res.isPresent() ? res.get() : null;
    }

    @Override
    public void deleteFind(PersonaEntity value) {
        repository.delete(value);
    }

}
