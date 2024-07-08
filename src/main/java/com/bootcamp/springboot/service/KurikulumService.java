package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.KurikulumModel;

import java.util.List;
import java.util.Optional;

public interface KurikulumService {
    List<KurikulumModel> getAll();
    Optional<KurikulumModel> getById(Integer id);
    Optional<KurikulumModel> save(KurikulumModel request);
    Optional<KurikulumModel> update(Integer id, KurikulumModel request);
    Optional<KurikulumModel> delete(Integer id);
}
