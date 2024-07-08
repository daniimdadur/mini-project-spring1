package com.bootcamp.springboot.service.serviceimpl;

import com.bootcamp.springboot.entity.KurikulumEntity;
import com.bootcamp.springboot.model.KurikulumModel;
import com.bootcamp.springboot.repository.KurikulumRepo;
import com.bootcamp.springboot.service.KurikulumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class KurikulumServiceImpl implements KurikulumService {

    private KurikulumRepo kurikulumRepo;

    public KurikulumServiceImpl(KurikulumRepo kurikulumRepo){
        this.kurikulumRepo = kurikulumRepo;
    }

    @Override
    public List<KurikulumModel> getAll() {
        List<KurikulumEntity> result = this.kurikulumRepo.findAll();
        if (result.isEmpty()){
            return Collections.emptyList();
        }
        return result.stream().map(KurikulumModel::new).collect(Collectors.toList());
    }

    @Override
    public Optional<KurikulumModel> getById(Integer id) {
        KurikulumEntity kurikulumEntity = this.kurikulumRepo.findById(id).orElse(null);
        if (kurikulumEntity == null){
            return Optional.empty();
        }
        KurikulumModel kurikulumModel = new KurikulumModel(kurikulumEntity);
        return Optional.of(kurikulumModel);
    }

    @Override
    public Optional<KurikulumModel> save(KurikulumModel request) {
        KurikulumEntity kurikulumEntity = new KurikulumEntity();

        BeanUtils.copyProperties(request, kurikulumEntity);
        try {
            this.kurikulumRepo.save(kurikulumEntity);
            log.info("save kurikulum to database success");
            return Optional.of(new KurikulumModel(kurikulumEntity));
        }catch (Exception e){
            log.error("save kurikulum to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<KurikulumModel> update(Integer id, KurikulumModel request) {
        KurikulumEntity kurikulumEntity = this.kurikulumRepo.findById(id).orElse(null);
        if (kurikulumEntity == null){
            log.info("kurikulum with id: {} not found", id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, kurikulumEntity);
        try {
            this.kurikulumRepo.save(kurikulumEntity);
            log.info("update kurikulum to database success");
            return Optional.of(new KurikulumModel(kurikulumEntity));
        } catch (Exception e){
            log.error("update kurikulum to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<KurikulumModel> delete(Integer id) {
        KurikulumEntity kurikulumEntity =  this.kurikulumRepo.findById(id).orElse(null);
        if (kurikulumEntity == null){
            log.warn("kurikulum with id: {} not found", id);
            return Optional.empty();
        }
        try {
            this.kurikulumRepo.delete(kurikulumEntity);
            log.info("delete kurikulum from database success");
            return Optional.of(new KurikulumModel(kurikulumEntity));
        }catch (Exception e){
            log.error("delete kurikulum from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
