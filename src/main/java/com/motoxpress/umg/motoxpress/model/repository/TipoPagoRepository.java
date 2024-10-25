

    package com.motoxpress.umg.motoxpress.model.repository;

    import java.util.Optional;
    
    import org.springframework.data.jpa.repository.JpaRepository;

import com.motoxpress.umg.motoxpress.model.entity.TipoPagoEntity;




    public interface TipoPagoRepository extends JpaRepository<TipoPagoEntity,Long>{
        Optional<TipoPagoEntity> findById(Long id);
    
    }