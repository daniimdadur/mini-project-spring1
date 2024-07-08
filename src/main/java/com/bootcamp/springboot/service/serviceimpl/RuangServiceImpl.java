package com.bootcamp.springboot.service.serviceimpl;

import com.bootcamp.springboot.entity.RuangEntity;
import com.bootcamp.springboot.model.RuangModel;
import com.bootcamp.springboot.repository.RuangRepo;
import com.bootcamp.springboot.service.RuangService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RuangServiceImpl implements RuangService {

    private RuangRepo ruangRepo;

    public RuangServiceImpl(RuangRepo ruangRepo) {
        this.ruangRepo = ruangRepo;
    }

    @Override
    public List<RuangModel> getAll() {
        List<RuangEntity> result = this.ruangRepo.findAll();
        if (result.isEmpty()){
            return Collections.emptyList();
        }
        return result.stream().map(RuangModel::new).collect(Collectors.toList());
    }

    @Override
    public Optional<RuangModel> getById(Integer id) {
        RuangEntity ruangEntity = this.ruangRepo.findById(id).orElse(null);
        if (ruangEntity == null){
            return Optional.empty();
        }
        RuangModel ruangModel = new RuangModel(ruangEntity);
        return Optional.of(ruangModel);
    }

    @Override
    public Optional<RuangModel> save(RuangModel request) {
        RuangEntity result = new RuangEntity();

        BeanUtils.copyProperties(request, result);
        try {
            this.ruangRepo.save(result);
            log.info("save ruang to database success");
            return Optional.of(new RuangModel(result));
        } catch (Exception e){
            log.error("save ruang to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RuangModel> edit(Integer id, RuangModel request) {
        RuangEntity ruangEntity = this.ruangRepo.findById(id).orElse(null);
            if (ruangEntity == null){
                log.info("ruang with id: {} not found", id);
                return Optional.empty();
            }
            BeanUtils.copyProperties(request, ruangEntity);
            try {
                this.ruangRepo.save(ruangEntity);
                log.info("update ruang to database success");
                return Optional.of(new RuangModel(ruangEntity));
            } catch (Exception e){
                log.error("update ruang to database failed, error: {}",e.getMessage());
                return Optional.empty();

        }
    }

    @Override
    public Optional<RuangModel> delete(Integer id) {
        RuangEntity ruangEntity = this.ruangRepo.findById(id).orElse(null);
        if (ruangEntity == null){
            log.warn("ruang with id: {} not found", id);
            return Optional.empty();
        }
        try {
            this.ruangRepo.delete(ruangEntity);
            log.info("delete ruang from database success");
            return Optional.of(new RuangModel(ruangEntity));
        } catch (Exception e){
            log.error("delete ruang from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
