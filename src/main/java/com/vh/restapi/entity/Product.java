package com.vh.restapi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "barcode")
    private String barcode;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Column(nullable = false)
    private List<Picture> pictures;

    public Product() {
    }

    public Product(int id, @NotNull String name, @NotNull String barcode, List<Picture> pictures) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.pictures = pictures;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}
