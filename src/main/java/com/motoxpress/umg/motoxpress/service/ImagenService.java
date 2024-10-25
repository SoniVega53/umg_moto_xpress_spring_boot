

    package com.motoxpress.umg.motoxpress.service;

    import java.util.List;
    import java.util.Optional;
    
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

import com.motoxpress.umg.motoxpress.model.entity.ImagenEntity;
import com.motoxpress.umg.motoxpress.model.repository.ImagenRepository;

    
    @Service
    public class ImagenService {
        @Autowired
        private ImagenRepository repository;
    
        public List<ImagenEntity> getDataList() {
            return (List<ImagenEntity>) repository.findAll();
        }
    
         public ImagenEntity getFindUncle(Long value) {
            Optional<ImagenEntity> res = repository.findById(value);
            return res.isPresent() ? res.get() : null;
        }
    }