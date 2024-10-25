package com.motoxpress.umg.motoxpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.motoxpress.umg.motoxpress.model.entity.TipoPagoEntity;

import com.motoxpress.umg.motoxpress.model.repository.TipoPagoRepository;

@Service
public class TipoPagoService {
    @Autowired
    private TipoPagoRepository repository;

    public List<TipoPagoEntity> getDataList() {
        return (List<TipoPagoEntity>) repository.findAll();
    }

     public TipoPagoEntity getFindUncle(Long value) {
        Optional<TipoPagoEntity> res = repository.findById(value);
        return res.isPresent() ? res.get() : null;
    }
}