package com.bootcamp.springboot.repository;

import com.bootcamp.springboot.entity.GedungEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GedungRepo extends JpaRepository<GedungEntity, Integer> {
}
