package com.bootcamp.springboot.service.serviceimpl;

import com.bootcamp.springboot.entity.GuruEntity;
import com.bootcamp.springboot.model.GuruModel;
import com.bootcamp.springboot.repository.GuruRepo;
import com.bootcamp.springboot.service.GuruService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GuruServiceImpl implements GuruService {

    private GuruRepo guruRepo;

    public GuruServiceImpl(GuruRepo guruRepo) {
        this.guruRepo = guruRepo;
    }

    @Override
    public List<GuruModel> getAll() {
        List<GuruEntity> result = this.guruRepo.findAll();
        if (result.isEmpty()){
            return Collections.emptyList();
        }
        return result.stream().map(GuruModel::new).collect(Collectors.toList());
    }

    @Override
    public Optional<GuruModel> getById(Integer id) {
        GuruEntity guruEntity = this.guruRepo.findById(id).orElse(null);
        if (guruEntity == null){
            return Optional.empty();
        }
        GuruModel guruModel = new GuruModel(guruEntity);
        return Optional.of(guruModel);
    }

    @Override
    public Optional<GuruModel> save(GuruModel request) {
        GuruEntity guruEntity = new GuruEntity();

        BeanUtils.copyProperties(request, guruEntity);
        try {
            this.guruRepo.save(guruEntity);
            log.info("save guru to database success");
            return Optional.of(new GuruModel(guruEntity));
        } catch (Exception e){
            log.error("save guru to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<GuruModel> update(Integer id, GuruModel request) {
        GuruEntity guruEntity = this.guruRepo.findById(id).orElse(null);
        if (guruEntity == null){
            log.info("guru with id: {} not found",id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(request,guruEntity);
        try {
            this.guruRepo.save(guruEntity);
            log.info("update guru to database success");
            return Optional.of(new GuruModel(guruEntity));
        } catch (Exception e){
            log.error("update guru to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<GuruModel> delete(Integer id) {
        GuruEntity guruEntity = this.guruRepo.findById(id).orElse(null);
        if (guruEntity == null){
            log.warn("guru with id: {} not found",id);
            return Optional.empty();
        }
        try {
            this.guruRepo.delete(guruEntity);
            log.info("delete guru from database success");
            return Optional.of(new GuruModel(guruEntity));
        } catch (Exception e){
            log.error("delete guru from database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }
}
