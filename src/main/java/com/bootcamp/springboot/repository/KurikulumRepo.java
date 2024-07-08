package com.bootcamp.springboot.repository;

import com.bootcamp.springboot.entity.KurikulumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KurikulumRepo extends JpaRepository<KurikulumEntity, Integer> {
}
