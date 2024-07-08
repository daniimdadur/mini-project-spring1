package com.bootcamp.springboot.service.serviceimpl;

import com.bootcamp.springboot.entity.OrangEntity;
import com.bootcamp.springboot.model.OrangModel;
import com.bootcamp.springboot.repository.OrangRepo;
import com.bootcamp.springboot.service.OrangService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrangServiceImpl implements OrangService {

    private OrangRepo orangRepo;

    public OrangServiceImpl(OrangRepo orangRepo) {
        this.orangRepo = orangRepo;
    }

    @Override
    public List<OrangModel> getAll() {
        List<OrangEntity> result = this.orangRepo.findAll();
        if (result.isEmpty()){
            return Collections.emptyList();
        }
        return result.stream().map(OrangModel::new).collect(Collectors.toList());
    }

    @Override
    public Optional<OrangModel> getById(Integer id) {
        OrangEntity orangEntity = this.orangRepo.findById(id).orElse(null);
        if (orangEntity == null){
            return Optional.empty();
        }
        OrangModel orangModel = new OrangModel(orangEntity);
        return Optional.of(orangModel);
    }

    @Override
    public Optional<OrangModel> save(OrangModel request) {
        OrangEntity result = new OrangEntity();

        BeanUtils.copyProperties(request,result);
        try {
            this.orangRepo.save(result);
            log.info("save orang to database success");
            return Optional.of(new OrangModel(result));
        } catch (Exception e ){
            log.error("save orang to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<OrangModel> update(OrangModel request, Integer id) {
        OrangEntity result = this.orangRepo.findById(id).orElse(null);
        if (result == null){
            log.info("orang with id :{} not found",id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(request,result);
        try {
            this.orangRepo.save(result);
            log.info("update orang to database success");
            return Optional.of(new OrangModel(result));
        } catch (Exception e){
            log.error("update orang to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<OrangModel> delete(Integer id) {
        OrangEntity result = this.orangRepo.findById(id).orElse(null);
        if (result == null){
            log.warn("orang with id :{} not found",id);
            return Optional.empty();
        }
        try {
            this.orangRepo.delete(result);
            log.info("delete orang from database success");
            return Optional.of(new OrangModel(result));
        } catch (Exception e){
            log.error("delete orang from database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }
}
