package com.bootcamp.springboot.model;

import com.bootcamp.springboot.entity.SiswaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiswaModel {

    private Integer id;
    private String nama;
    private String nim;
    private String jk;
    private String ttl;
    private String alamat;

    public SiswaModel(SiswaEntity siswaEntity){
        BeanUtils.copyProperties(siswaEntity,this);
    }
}