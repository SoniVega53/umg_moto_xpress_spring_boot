
    package com.motoxpress.umg.motoxpress.model.repository;

    import java.util.Optional;
    
    import org.springframework.data.jpa.repository.JpaRepository;
    

import com.motoxpress.umg.motoxpress.model.entity.PagoEstadoEntity;
    
    
    public interface PagoEstadoRepository extends JpaRepository<PagoEstadoEntity,Long>{
        Optional<PagoEstadoEntity> findByDescripcion(String descripcion);
    
    }