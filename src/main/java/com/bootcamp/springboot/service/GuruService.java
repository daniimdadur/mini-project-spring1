package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.GuruModel;

import java.util.List;
import java.util.Optional;

public interface GuruService {

    List<GuruModel> getAll();
    Optional<GuruModel> getById(Integer id);
    Optional<GuruModel> save(GuruModel request);
    Optional<GuruModel> update(Integer id, GuruModel request);
    Optional<GuruModel> delete(Integer id);
}
