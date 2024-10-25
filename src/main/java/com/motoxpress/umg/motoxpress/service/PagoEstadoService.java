





    package com.motoxpress.umg.motoxpress.service;

    import java.util.List;
    import java.util.Optional;
    
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

import com.motoxpress.umg.motoxpress.model.entity.PagoEstadoEntity;

import com.motoxpress.umg.motoxpress.model.repository.PagoEstadoRepository;


    
    @Service
    public class PagoEstadoService {
        @Autowired
        private PagoEstadoRepository repository;
    
        public List<PagoEstadoEntity> getDataList() {
            return (List<PagoEstadoEntity>) repository.findAll();
        }
    
         public PagoEstadoEntity getFindUncle(Long value) {
            Optional<PagoEstadoEntity> res = repository.findById(value);
            return res.isPresent() ? res.get() : null;
        }
    }