package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.SekolahModel;

import java.util.List;
import java.util.Optional;

public interface SekolahService {
    List<SekolahModel> getAll();
    Optional<SekolahModel> getById(Integer id);
    Optional<SekolahModel> save(SekolahModel request);
    Optional<SekolahModel> update(Integer id, SekolahModel request);
    Optional<SekolahModel> delete(Integer id);
}
