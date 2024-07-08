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
@Table(name = "tbl_guru")
public class GuruEntity {

    @Id
    @Column
    private Integer id;

    @Column(name = "nama", length = 200)
    private String nama;

    @Column(name = "nip", length = 20)
    private String nip;

    @Column(name = "jk", length = 20)
    private String jk;

    @Column(name = "gelar", length = 200)
    private String gelar;

    @Column(name = "alamat", length = 250)
    private String alamat;
}
