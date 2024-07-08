package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.SiswaModel;

import java.util.List;
import java.util.Optional;

public interface SiswaService {

    List<SiswaModel> getAll();
    Optional<SiswaModel> getById(Integer id);
    Optional<SiswaModel> save(SiswaModel request);
    Optional<SiswaModel> update(SiswaModel siswaModel, Integer id);
    Optional<SiswaModel> delete(Integer id);
}
