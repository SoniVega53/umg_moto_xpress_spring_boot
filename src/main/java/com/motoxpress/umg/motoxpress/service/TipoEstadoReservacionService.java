


    package com.motoxpress.umg.motoxpress.service;

    import java.util.List;
    import java.util.Optional;
    
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

import com.motoxpress.umg.motoxpress.model.entity.TipoEstadoReservacionEntity;
import com.motoxpress.umg.motoxpress.model.repository.TipoEstadoReservacionRepository;

    
    @Service
    public class TipoEstadoReservacionService {
        @Autowired
        private TipoEstadoReservacionRepository repository;
    
        public List<TipoEstadoReservacionEntity> getDataList() {
            return (List<TipoEstadoReservacionEntity>) repository.findAll();
        }
    
         public TipoEstadoReservacionEntity getFindUncle(Long value) {
            Optional<TipoEstadoReservacionEntity> res = repository.findById(value);
            return res.isPresent() ? res.get() : null;
        }
    }