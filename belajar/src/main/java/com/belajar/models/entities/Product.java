package com.belajar.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="tb_m_product")
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama;
    private String kategori;
    private Integer harga;
    private Integer stok;
    private String deskripsi;
    private String gambar;

    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "tb_m_supplier_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    @JsonManagedReference
    private Set<Supplier> suppliers;

    public Product() {
    }

    public Product(Integer id, String nama, String kategori, Integer harga, Integer stok, String deskripsi, String gambar) {
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }
}
