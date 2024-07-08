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
@Table(name = "tbl_sekolah")
public class SekolahEntity {

    @Id
    @Column
    private Integer id;

    @Column(name = "namaSekolah")
    private String namaSekolah;

    @Column(name = "namaJalan")
    private String namaJalan;

    @Column(name = "alamatSekolah")
    private String alamatSekolah;
}
