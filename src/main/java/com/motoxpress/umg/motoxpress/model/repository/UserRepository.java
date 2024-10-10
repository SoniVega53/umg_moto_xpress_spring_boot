package com.motoxpress.umg.motoxpress.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.motoxpress.umg.motoxpress.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{
    Optional<UserEntity> findByUsername(String username);

}
