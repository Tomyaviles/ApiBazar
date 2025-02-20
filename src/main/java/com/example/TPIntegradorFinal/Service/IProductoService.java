package com.example.TPIntegradorFinal.Service;

import com.example.TPIntegradorFinal.Model.Producto;

import java.util.List;

public interface IProductoService {

    ///Get
    public List<Producto> getAllProductos();

    public Producto getProductoById(Long id);

    //alta
    public void saveProducto(Producto producto);


    //baja

    public void deleteProducto(Long id);


    //PUT

    public void editProducto(Long id, Producto producto);


    ///OBTENER PRODUCTOS CUYA CANTIDAD SEA MENOR A 5

    public List<Producto> obtenerProductosMenor5();

    ///ACTUALIZAR STOCK

    public Producto actualizarStrock(Long id, int cantidad);
}
