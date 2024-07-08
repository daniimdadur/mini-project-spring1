package com.bootcamp.springboot.repository;

import com.bootcamp.springboot.entity.RuangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuangRepo extends JpaRepository<RuangEntity, Integer> {
}
