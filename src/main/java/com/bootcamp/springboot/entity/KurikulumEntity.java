package com.bootcamp.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_kurikulum")
public class KurikulumEntity {

    @Id
    @Column
    private Integer id;

    @Column(name = "kodeKurikulum", length = 30)
    private String kode;

    @Column(name = "namaKurikulum", length = 50)
    private String nama;
}
