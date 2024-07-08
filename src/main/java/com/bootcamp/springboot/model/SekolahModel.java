package com.bootcamp.springboot.model;

import com.bootcamp.springboot.entity.SekolahEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SekolahModel {

    private Integer id;
    private String namaSekolah;
    private String namaJalan;
    private String alamatSekolah;

    public SekolahModel(SekolahEntity sekolahEntity){
        BeanUtils.copyProperties(sekolahEntity, this);
    }
}
