package com.bootcamp.springboot.repository;

import com.bootcamp.springboot.entity.SekolahEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SekolahRepo extends JpaRepository<SekolahEntity, Integer> {
}
