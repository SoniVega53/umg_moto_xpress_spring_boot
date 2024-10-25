
    package com.motoxpress.umg.motoxpress.model.repository;

    import java.util.Optional;
    
    import org.springframework.data.jpa.repository.JpaRepository;

import com.motoxpress.umg.motoxpress.model.entity.MetodoRentaEntity;



    public interface MetodoRentaRepository extends JpaRepository<MetodoRentaEntity,Long>{
        Optional<MetodoRentaEntity> findById(Long id);
    
    }
