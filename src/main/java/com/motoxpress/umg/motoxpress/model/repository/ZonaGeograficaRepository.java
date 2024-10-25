
    package com.motoxpress.umg.motoxpress.model.repository;

    import java.util.Optional;
    
    import org.springframework.data.jpa.repository.JpaRepository;


import com.motoxpress.umg.motoxpress.model.entity.ZonaGeograficaEntity;



    public interface ZonaGeograficaRepository extends JpaRepository<ZonaGeograficaEntity,Long>{
        Optional<ZonaGeograficaEntity> findByName(String nombre_zona);
    
    }
