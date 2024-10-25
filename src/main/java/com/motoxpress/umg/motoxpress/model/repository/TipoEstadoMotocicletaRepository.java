

    package com.motoxpress.umg.motoxpress.model.repository;

    import java.util.Optional;
    
    import org.springframework.data.jpa.repository.JpaRepository;

import com.motoxpress.umg.motoxpress.model.entity.TipoEstadoMotocicletaEntity;




    public interface TipoEstadoMotocicletaRepository extends JpaRepository<TipoEstadoMotocicletaEntity,Long>{
        Optional<TipoEstadoMotocicletaEntity> findyByDescripcion(String descripcion);
    
    }
