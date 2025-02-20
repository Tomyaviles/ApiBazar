package com.example.TPIntegradorFinal.Service;

import com.example.TPIntegradorFinal.Model.Producto;
import com.example.TPIntegradorFinal.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getAllProductos() {
        List<Producto> productos = productoRepository.findAll();

        return productos;
    }



    @Override
    public Producto getProductoById(Long id) {
        Producto producto = productoRepository.findById(id).orElse(null);

        return producto;
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public void editProducto(Long id_original, Producto producto) {
        Producto aux = productoRepository.findById(id_original).orElse(null);
        aux.setNombre(producto.getNombre());
        aux.setMarca(producto.getMarca());
        aux.setCantidad_disponible(producto.getCantidad_disponible());
        aux.setPrecio(producto.getPrecio());
        aux.setCodigo_producto(id_original);

        productoRepository.save(aux);


    }


    @Override
    public List<Producto> obtenerProductosMenor5() {
        List<Producto> productosFaltantes = new ArrayList<>();

        for(Producto producto: productoRepository.findAll()) {
            if(producto.getCantidad_disponible() > 5 ){
                productosFaltantes.add(producto);
            }
        }

        return productosFaltantes;
    }

    @Override
    public Producto actualizarStrock(Long id, int cantidad) {
        Producto producto = productoRepository.findById(id).orElse(null);
        productoRepository.findById(id).orElse(null).setCantidad_disponible(producto.getCantidad_disponible() + cantidad);
        Producto aux = productoRepository.findById(id).orElse(null);
        this.saveProducto(aux);
        return aux;
    }
}
