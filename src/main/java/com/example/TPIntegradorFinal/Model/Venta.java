package com.example.TPIntegradorFinal.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;


    @ElementCollection
    @CollectionTable(
            name = "venta_producto",
            joinColumns = @JoinColumn(name = "venta_id")
    )
    private List<ProductoCantidad> productos;


    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;


    public Venta(LocalDate fecha_venta, Cliente cliente) {
        this.fecha_venta = fecha_venta;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    public Venta() {
    }

    public Long getCodigo_venta() {
        return codigo_venta;
    }


    public void setCodigo_venta(Long codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<ProductoCantidad> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoCantidad> productos) {
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getUncliente() {
        return cliente;
    }

    public void setUncliente(Cliente uncliente) {
        this.cliente = uncliente;
    }


                    ///METODOS

    public void calcularTotal() {

        total = 0.0;

        for(ProductoCantidad productoCantidad : productos){
            Producto producto = productoCantidad.getProducto();
            if(producto.getPrecio() != null){
                Double cantidad = productoCantidad.getCantidad();
                total += producto.getPrecio() * cantidad;
                System.out.println("El total: " + total);
            }else{
                System.out.println("Error en el precio del producto");
            }
        }
    }
}
