package com.bootcamp.springboot.model;

import com.bootcamp.springboot.entity.KurikulumEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KurikulumModel {

    private Integer id;
    private String kode;
    private String nama;

    public KurikulumModel(KurikulumEntity kurikulumEntity){
        BeanUtils.copyProperties(kurikulumEntity, this);
    }
}
