package com.bootcamp.springboot.model;

import com.bootcamp.springboot.entity.GedungEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GedungModel {

    private Integer id;
    private String namaGedung;
    private String kodeGedung;
    private Integer jumlahLantai;

    public GedungModel(GedungEntity gedungEntity){
        BeanUtils.copyProperties(gedungEntity, this);
    }
}
