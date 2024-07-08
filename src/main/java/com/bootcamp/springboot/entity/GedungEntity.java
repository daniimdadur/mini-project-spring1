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
@Table(name = "tbl_gedung")
public class GedungEntity {

    @Id
    @Column
    private Integer id;

    @Column(name = "namaGedung")
    private String namaGedung;

    @Column(name = "kodeGedung")
    private String kodeGedung;

    @Column(name = "jumlahLantai")
    private Integer jumlahLantai;
}
