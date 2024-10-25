


    package com.motoxpress.umg.motoxpress.model.repository;

    import java.util.Optional;
    
    import org.springframework.data.jpa.repository.JpaRepository;


import com.motoxpress.umg.motoxpress.model.entity.MotocicletaEntity;



    public interface MotocicletaRepository extends JpaRepository<MotocicletaEntity,Long>{
        Optional<MotocicletaEntity> findByKilimotraje(String kilometraje);
    
    }
