package com.bootcamp.springboot.repository;

import com.bootcamp.springboot.entity.OrangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrangRepo extends JpaRepository<OrangEntity, Integer> {

}
