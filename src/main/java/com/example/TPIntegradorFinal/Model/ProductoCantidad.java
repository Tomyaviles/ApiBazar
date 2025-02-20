package com.example.TPIntegradorFinal.Model;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jdk.jfr.Enabled;

@Embeddable
public class ProductoCantidad {

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    private Double cantidad;


    public ProductoCantidad(Producto producto, Double cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public ProductoCantidad() {
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}
