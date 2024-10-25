

    package com.motoxpress.umg.motoxpress.model.repository;

    import java.util.Optional;
    
    import org.springframework.data.jpa.repository.JpaRepository;

import com.motoxpress.umg.motoxpress.model.entity.TipoEstadoReservacionEntity;



    public interface TipoEstadoReservacionRepository extends JpaRepository<TipoEstadoReservacionEntity,Long>{
        Optional<TipoEstadoReservacionEntity> findById(Long id);
    
    }
