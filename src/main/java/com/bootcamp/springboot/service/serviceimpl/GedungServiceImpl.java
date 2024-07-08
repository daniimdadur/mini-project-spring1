package com.bootcamp.springboot.service.serviceimpl;

import com.bootcamp.springboot.entity.GedungEntity;
import com.bootcamp.springboot.model.GedungModel;
import com.bootcamp.springboot.repository.GedungRepo;
import com.bootcamp.springboot.service.GedungService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GedungServiceImpl implements GedungService {

    private GedungRepo gedungRepo;

    public GedungServiceImpl(GedungRepo gedungRepo) {
        this.gedungRepo = gedungRepo;
    }

    @Override
    public List<GedungModel> getAll() {
        List<GedungEntity> result = this.gedungRepo.findAll();
        if (result.isEmpty()){
            return Collections.emptyList();
        }
        return result.stream().map(GedungModel::new).collect(Collectors.toList());
    }

    @Override
    public Optional<GedungModel> getById(Integer id) {
        GedungEntity gedungEntity = this.gedungRepo.findById(id).orElse(null);
        if (gedungEntity == null){
            return Optional.empty();
        }
        GedungModel gedungModel = new GedungModel(gedungEntity);
        return Optional.of(gedungModel);
    }

    @Override
    public Optional<GedungModel> save(GedungModel request) {
        GedungEntity gedungEntity = new GedungEntity();

        BeanUtils.copyProperties(request, gedungEntity);
        try {
            this.gedungRepo.save(gedungEntity);
            log.info("save gedung to database success");
            return Optional.of(new GedungModel(gedungEntity));
        } catch (Exception e){
            log.error("save gedung to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<GedungModel> edit(Integer id, GedungModel request) {
        GedungEntity gedungEntity = this.gedungRepo.findById(id).orElse(null);
        if (gedungEntity == null){
            log.info("gedung with id: {} not found", id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, gedungEntity);
        try {
            this.gedungRepo.save(gedungEntity);
            log.info("update gedung to database success");
            return Optional.of(new GedungModel(gedungEntity));
        } catch (Exception e){
            log.error("update gedung to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<GedungModel> delete(Integer id) {
        GedungEntity gedungEntity = this.gedungRepo.findById(id).orElse(null);
        if (gedungEntity == null){
            log.warn("gedung with id: {} not found", id);
            return Optional.empty();
        }
        try {
            this.gedungRepo.delete(gedungEntity);
            log.info("delete gedung from database success");
            return Optional.of(new GedungModel(gedungEntity));
        }catch (Exception e){
            log.error("delete gedung from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
