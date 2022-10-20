package com.example.laboratory.models;

import com.example.laboratory.utils.Care;
import com.example.laboratory.utils.Material;
import com.example.laboratory.utils.Wear;

public class Elements {
    private String name;
    private Material material;
    private Care care;
    private int stock;
    private String code;
    private boolean status;

    public Elements(String name, Material material, Care care, int stock, String code, boolean status) {
        this.name = name;
        this.material = material;
        this.care = care;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Elements{" +
                "name='" + name + '\'' +
                ", material=" + material +
                ", care=" + care +
                ", stock=" + stock +
                ", code='" + code + '\'' +
                ", status=" + status +
                '}';
    }
}
