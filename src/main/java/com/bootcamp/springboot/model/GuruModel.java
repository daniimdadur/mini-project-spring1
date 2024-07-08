package com.bootcamp.springboot.model;

import com.bootcamp.springboot.entity.GuruEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuruModel {

    private Integer id;
    private String nama;
    private String nip;
    private String jk;
    private String gelar;
    private String alamat;

    public GuruModel(GuruEntity guruEntity){
        BeanUtils.copyProperties(guruEntity,this);
    }
}
