

    package com.motoxpress.umg.motoxpress.model.repository;

    import java.util.Optional;
    
    import org.springframework.data.jpa.repository.JpaRepository;


import com.motoxpress.umg.motoxpress.model.entity.ModeloEntity;



    public interface ModeloRepository extends JpaRepository<ModeloEntity,Long>{
        Optional<ModeloEntity> findByYear(String año);
    
    }