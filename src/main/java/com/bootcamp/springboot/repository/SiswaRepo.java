package com.bootcamp.springboot.repository;

import com.bootcamp.springboot.entity.SiswaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiswaRepo extends JpaRepository<SiswaEntity, Integer> {
}
