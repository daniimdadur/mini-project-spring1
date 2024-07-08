package com.bootcamp.springboot.model;

import com.bootcamp.springboot.entity.RuangEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuangModel {

    private Integer id;
    private String namaRuang;
    private String kodeRuang;

    public RuangModel(RuangEntity ruangEntity){
        BeanUtils.copyProperties(ruangEntity, this);
    }
}
