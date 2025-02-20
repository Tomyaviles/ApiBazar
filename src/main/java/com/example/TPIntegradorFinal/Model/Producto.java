package com.example.TPIntegradorFinal.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long codigo_producto;
    private String nombre;
    private String marca;
    private Double precio;
    private Double cantidad_disponible;

    public Producto(long codigo_producto, String nombre, String marca, Double precio, Double cantidad_disponible) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.cantidad_disponible = cantidad_disponible;
    }

    public Producto() {
    }

    public long getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(long codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(Double cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }
}
