package com.bootcamp.springboot.service.serviceimpl;

import com.bootcamp.springboot.entity.SiswaEntity;
import com.bootcamp.springboot.model.SiswaModel;
import com.bootcamp.springboot.repository.SiswaRepo;
import com.bootcamp.springboot.service.SiswaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SiswaServiceImpl implements SiswaService {

    private SiswaRepo siswaRepo;

    public SiswaServiceImpl(SiswaRepo siswaRepo) {
        this.siswaRepo = siswaRepo;
    }

    @Override
    public List<SiswaModel> getAll() {
        List<SiswaEntity> result = this.siswaRepo.findAll();
        if (result.isEmpty()){
            return Collections.emptyList();
        }
        return result.stream().map(SiswaModel::new).collect(Collectors.toList());
    }

    @Override
    public Optional<SiswaModel> getById(Integer id) {
        SiswaEntity result  = this.siswaRepo.findById(id).orElse(null);
        if (result == null){
            return Optional.empty();
        }
        SiswaModel siswaModel = new SiswaModel(result);
        return Optional.of(siswaModel);
    }

    @Override
    public Optional<SiswaModel> save(SiswaModel request) {
        SiswaEntity siswaEntity = new SiswaEntity();

        BeanUtils.copyProperties(request,siswaEntity);
        try {
            this.siswaRepo.save(siswaEntity);
            log.info("Save siswa to database success");
            return Optional.of(new SiswaModel(siswaEntity));
        } catch (Exception e){
            log.error("Save siswa to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SiswaModel> update(SiswaModel siswaModel, Integer id) {
        SiswaEntity result = this.siswaRepo.findById(id).orElse(null);
        if (result == null){
            log.info("Siswa with id: {} not found",id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(siswaModel,result);
        try {
            this.siswaRepo.save(result);
            log.info("update siswa to database success");
            return Optional.of(new SiswaModel(result));
        } catch (Exception e){
            log.error("update siswa to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SiswaModel> delete(Integer id) {
        SiswaEntity result = this.siswaRepo.findById(id).orElse(null);
        if (result == null){
            log.warn("siswa with id :{} not found",id);
            return Optional.empty();
        }
        try {
            this.siswaRepo.delete(result);
            log.info("delete siswa id : {}, from database success",id);
            return Optional.of(new SiswaModel(result));
        } catch (Exception e){
            log.error("delete siswa from database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }
}
