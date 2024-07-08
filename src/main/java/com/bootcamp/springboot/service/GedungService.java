package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.GedungModel;

import java.util.List;
import java.util.Optional;

public interface GedungService {
    List<GedungModel> getAll();
    Optional<GedungModel> getById(Integer id);
    Optional<GedungModel> save(GedungModel request);
    Optional<GedungModel> edit(Integer id, GedungModel request);
    Optional<GedungModel> delete(Integer id);
}
