package com.motoxpress.umg.motoxpress.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.motoxpress.umg.motoxpress.model.entity.Pagos.PagoEntity;

public interface PagoRepository extends JpaRepository<PagoEntity,Long>{
    
}
