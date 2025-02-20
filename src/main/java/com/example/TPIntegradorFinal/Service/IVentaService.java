package com.example.TPIntegradorFinal.Service;

import com.example.TPIntegradorFinal.Model.Producto;
import com.example.TPIntegradorFinal.Model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    ///Get

    public List<Venta> getAllVentas();

    public Venta getVentaById(Long id);

    ///alta

    public void saveVenta(Venta venta);

    //baja

    public void deleteVenta(Long id);


    ///modificar

    public void editVenta(Long id, Venta venta);


    ///Obtener productos de una determinada venta

    public List<Producto> ObtenerProductos(Long id_venta);


    ///Obtener la sumatoria de ventas de un dia y la cantidad

    public Integer ObtenerCantidadVentas(LocalDate fecha_venta);
    public Double ObtenerTotalVendido(LocalDate fecha_venta);

}
