

    package com.motoxpress.umg.motoxpress.model.repository;

    import java.util.Optional;
    
    import org.springframework.data.jpa.repository.JpaRepository;

import com.motoxpress.umg.motoxpress.model.entity.ImagenEntity;

    
    
    public interface ImagenRepository extends JpaRepository<ImagenEntity,Long>{
        Optional<ImagenEntity> findyByName(String nombre);
    
    }