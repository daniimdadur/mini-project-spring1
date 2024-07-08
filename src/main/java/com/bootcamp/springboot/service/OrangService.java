package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.OrangModel;


import java.util.List;
import java.util.Optional;


public interface OrangService {

    List<OrangModel> getAll();
    Optional<OrangModel> getById(Integer id);
    Optional<OrangModel> save(OrangModel request);
    Optional<OrangModel> update(OrangModel request, Integer id);
    Optional<OrangModel> delete(Integer id);

}
