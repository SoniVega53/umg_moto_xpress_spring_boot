




    package com.motoxpress.umg.motoxpress.service;

    import java.util.List;
    import java.util.Optional;
    
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

import com.motoxpress.umg.motoxpress.model.entity.MetodoRentaEntity;
import com.motoxpress.umg.motoxpress.model.repository.MetodoRentaRepository;


    
    @Service
    public class MetodoRentaService {
        @Autowired
        private MetodoRentaRepository repository;
    
        public List<MetodoRentaEntity> getDataList() {
            return (List<MetodoRentaEntity>) repository.findAll();
        }
    
         public MetodoRentaEntity getFindUncle(Long value) {
            Optional<MetodoRentaEntity> res = repository.findById(value);
            return res.isPresent() ? res.get() : null;
        }
    }