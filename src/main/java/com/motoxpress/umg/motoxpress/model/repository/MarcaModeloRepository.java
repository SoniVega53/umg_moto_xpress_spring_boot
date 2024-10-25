package com.motoxpress.umg.motoxpress.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.motoxpress.umg.motoxpress.model.entity.MarcaModeloEntity;


public interface MarcaModeloRepository extends JpaRepository<MarcaModeloEntity,Long>{
    Optional<MarcaModeloEntity> findByName(String nombre);

}