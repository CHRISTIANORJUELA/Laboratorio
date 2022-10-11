package com.example.laboratory.models;

import com.example.laboratory.utils.Care;
import com.example.laboratory.utils.Material;
import com.example.laboratory.utils.Wear;

public class Elements {
    private String name;
    private Material material;
    private Care care;
    private Wear wear;
    private int stock;
    private String code;
    private boolean status;

    public Elements(String name, Material material, Care care, Wear wear, int stock, String code, boolean status) {
        this.name = name;
        this.material = material;
        this.care = care;
        this.wear = wear;
        this.stock = stock;
        this.code = code;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Care getCare() {
        return care;
    }

    public void setCare(Care care) {
        this.care = care;
    }

    public Wear getWear() {
        return wear;
    }

    public void setWear(Wear wear) {
        this.wear = wear;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
