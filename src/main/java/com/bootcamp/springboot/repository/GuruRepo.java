package com.bootcamp.springboot.repository;

import com.bootcamp.springboot.entity.GuruEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuruRepo extends JpaRepository<GuruEntity,Integer> {
}
