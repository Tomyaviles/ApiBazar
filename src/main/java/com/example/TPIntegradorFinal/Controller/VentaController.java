package com.example.TPIntegradorFinal.Controller;


import com.example.TPIntegradorFinal.Model.Producto;
import com.example.TPIntegradorFinal.Model.Venta;
import com.example.TPIntegradorFinal.Service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;


                        ///ENDPOINTS

    ///CREACION
    @PostMapping
    public String crearVenta(@RequestBody Venta venta) {
        ventaService.saveVenta(venta);
        return "Venta guardada con exito";
    }

    ///LISTAR TODAS LAS VENTAS

    @GetMapping
    public List<Venta> listaVentas() {
        List<Venta> ventas = ventaService.getAllVentas();

        return ventas;
    }

    @GetMapping("/{id}")
    public Venta obtenerVenta(@PathVariable Long id) {
        Venta venta = ventaService.getVentaById(id);

        return venta;
    }

    ///ELIMINAR

    @DeleteMapping("/eliminar/{id}")
    public String eliminarVenta(@PathVariable Long id) {
        ventaService.deleteVenta(id);
        return "Venta eliminada con exito";
    }

    ///MODIFICAR
    ///NO MODIFICA ID

    @PutMapping("/editar/{id_original}")
    public Venta editarVenta(@PathVariable Long id_original,
                             @RequestBody Venta venta) {
        ventaService.editVenta(id_original, venta);
        Venta aux = ventaService.getVentaById(id_original);
        return aux;
    }


    ///OBTENER LISTA DE PRODUCTOS DE UNA DETERMINADA VENTA

    @GetMapping("/productos/{id_venta}")
    public List<Producto> listaProductos(@PathVariable Long id_venta) {
     List<Producto> productos = ventaService.ObtenerProductos(id_venta);

     return productos;
    }

    ///OBTENER SUMATORIA Y CANTIDAD DE VENTAS DE UN DIA

    @GetMapping("/{fecha_venta}")
    public String ObtenerSumatoriaYCantidad(@PathVariable LocalDate fecha_venta) {
        Integer cantidad = ventaService.ObtenerCantidadVentas(fecha_venta);
        Double total = ventaService.ObtenerTotalVendido(fecha_venta);

        return "La cantidad de ventas fue: " + cantidad + "\nY el total fue: " + total + "\n";
    }

}
