package com.example.TPIntegradorFinal.Controller;

import com.example.TPIntegradorFinal.Model.Producto;
import com.example.TPIntegradorFinal.Service.IProductoService;
import com.example.TPIntegradorFinal.Service.ProductoService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;


                        ///ENDPOINTS

    ///CREACION
    @PostMapping
    public String crearProducto(@RequestBody Producto producto) {
        productoService.saveProducto(producto);
        return "producto registrado con exito";
    }


    ///LISTAR PRODUCTO
    @GetMapping
    public List<Producto> getAllProductos() {
       return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        Producto producto = productoService.getProductoById(id);
        return producto;
    }

    ///ELIMINAR

    @DeleteMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return "producto eliminado con exito";
    }

    ///MODIFICAR
    ///NO MODIFICA ID

    @PutMapping("/editar/{id_original}")
    public Producto editProducto(@PathVariable Long id_original,
                                 @RequestBody Producto producto) {
        productoService.editProducto(id_original, producto);

        Producto productoActual = productoService.getProductoById(id_original);
        return productoActual;
    }



    ///FALTA STOCK
    ///OBTENER TODOS LOS PRODUCTOS QUE SU CANTIDAD SEA MENOR A 5

    @GetMapping("/falta_stock")
    public List<Producto> getProductoFaltaStock() {
        List<Producto> productos = productoService.obtenerProductosMenor5();

        return productos;
    }


    @PutMapping("/actualizar/{id}/{cantidad}")
    public Producto actualizarStock(@PathVariable Long id, @PathVariable Integer cantidad) {
        return productoService.actualizarStrock(id, cantidad);
    }





}
