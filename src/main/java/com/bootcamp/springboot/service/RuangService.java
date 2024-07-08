package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.RuangModel;

import java.util.List;
import java.util.Optional;

public interface RuangService {

    List<RuangModel> getAll();
    Optional<RuangModel> getById(Integer id);
    Optional<RuangModel> save(RuangModel request);
    Optional<RuangModel> edit(Integer id, RuangModel request);
    Optional<RuangModel> delete(Integer id);
}
