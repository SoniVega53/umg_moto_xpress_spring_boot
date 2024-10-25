

    package com.motoxpress.umg.motoxpress.service;

    import java.util.List;
    import java.util.Optional;
    
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

import com.motoxpress.umg.motoxpress.model.entity.TipoEstadoMotocicletaEntity;
import com.motoxpress.umg.motoxpress.model.repository.TipoEstadoMotocicletaRepository;

    
    @Service
    public class TipoEstadoMotocicletaService {
        @Autowired
        private TipoEstadoMotocicletaRepository repository;
    
        public List<TipoEstadoMotocicletaEntity> getDataList() {
            return (List<TipoEstadoMotocicletaEntity>) repository.findAll();
        }
    
         public TipoEstadoMotocicletaEntity getFindUncle(Long value) {
            Optional<TipoEstadoMotocicletaEntity> res = repository.findById(value);
            return res.isPresent() ? res.get() : null;
        }
    }