

    package com.motoxpress.umg.motoxpress.model.repository;

    import java.util.Optional;
    
    import org.springframework.data.jpa.repository.JpaRepository;

import com.motoxpress.umg.motoxpress.model.entity.InventarioEntity;

    
    
    public interface InventarioRepository extends JpaRepository<InventarioEntity,Long>{
        Optional<InventarioEntity> findyByDate(String fecha_disponibilidad);
    
    }