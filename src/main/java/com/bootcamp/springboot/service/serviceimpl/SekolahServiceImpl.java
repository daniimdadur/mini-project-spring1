package com.bootcamp.springboot.service.serviceimpl;

import com.bootcamp.springboot.entity.SekolahEntity;
import com.bootcamp.springboot.model.SekolahModel;
import com.bootcamp.springboot.repository.SekolahRepo;
import com.bootcamp.springboot.service.SekolahService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SekolahServiceImpl implements SekolahService {

    private SekolahRepo sekolahRepo;

    public SekolahServiceImpl(SekolahRepo sekolahRepo) {
        this.sekolahRepo = sekolahRepo;
    }

    @Override
    public List<SekolahModel> getAll() {
        List<SekolahEntity> result = this.sekolahRepo.findAll();
        if (result.isEmpty()){
            return Collections.emptyList();
        }
        return result.stream().map(SekolahModel::new).collect(Collectors.toList());
    }

    @Override
    public Optional<SekolahModel> getById(Integer id) {
        SekolahEntity sekolahEntity = this.sekolahRepo.findById(id).orElse(null);
        if (sekolahEntity == null){
            return Optional.empty();
        }
        SekolahModel sekolahModel = new SekolahModel(sekolahEntity);
        return Optional.of(sekolahModel);
    }

    @Override
    public Optional<SekolahModel> save(SekolahModel request) {
        SekolahEntity result = new SekolahEntity();

        BeanUtils.copyProperties(request, result);
        try {
            this.sekolahRepo.save(result);
            log.info("save sekolah to database success");
            return Optional.of(new SekolahModel(result));
        } catch (Exception e){
            log.error("save sekolah to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SekolahModel> update(Integer id, SekolahModel request) {
        SekolahEntity sekolahEntity = this.sekolahRepo.findById(id).orElse(null);
        if (sekolahEntity == null){
            log.info("sekolah with id: {} not found", id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, sekolahEntity);
        try {
            this.sekolahRepo.save(sekolahEntity);
            log.info("update sekolah to database success");
            return Optional.of(new SekolahModel(sekolahEntity));
        } catch (Exception e){
            log.error("update sekolah to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SekolahModel> delete(Integer id) {
        SekolahEntity sekolahEntity = this.sekolahRepo.findById(id).orElse(null);
        if (sekolahEntity == null){
            log.warn("sekolah with id: {} not found", id);
            return Optional.empty();
        }
        try {
            this.sekolahRepo.delete(sekolahEntity);
            log.info("delete sekolah from database success");
            return Optional.of(new SekolahModel(sekolahEntity));
        } catch (Exception e){
            log.error("delete sekolah from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
