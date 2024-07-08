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
@Table(name = "tbl_siswa")
public class SiswaEntity {

    @Id
    @Column
    private Integer id;

    @Column(name = "nama",length = 200)
    private String nama;

    @Column(name = "nim",length = 20)
    private String nim;

    @Column(name = "jk",length = 20)
    private String jk;

    @Column(name = "ttl",length = 200)
    private String ttl;

    @Column(name = "alamat",length = 200)
    private String alamat;
}
