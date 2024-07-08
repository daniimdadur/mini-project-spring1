package com.bootcamp.springboot.model;

import com.bootcamp.springboot.entity.OrangEntity;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrangModel {

    private Integer id;
    private String nama;
    private String jk;
    private String usia;
    private String alamat;

    public OrangModel(OrangEntity orangEntity) {
        BeanUtils.copyProperties(orangEntity, this);
    }
}
