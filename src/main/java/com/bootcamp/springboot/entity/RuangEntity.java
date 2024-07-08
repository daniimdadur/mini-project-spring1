package com.bootcamp.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tbl_ruang")
public class RuangEntity {

    @Id
    @Column
    private Integer id;

    @Column(name = "namaRuang")
    private String namaRuang;

    @Column(name = "kodeRuang")
    private String kodeRuang;
}
