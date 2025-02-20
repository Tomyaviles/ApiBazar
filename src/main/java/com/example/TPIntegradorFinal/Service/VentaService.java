package com.example.TPIntegradorFinal.Service;

import com.example.TPIntegradorFinal.Model.Producto;
import com.example.TPIntegradorFinal.Model.ProductoCantidad;
import com.example.TPIntegradorFinal.Model.Venta;
import com.example.TPIntegradorFinal.Repository.ProductoRepository;
import com.example.TPIntegradorFinal.Repository.VentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class VentaService implements IVentaService{

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Venta> getAllVentas() {
        List<Venta> ventas = ventaRepository.findAll();

        return ventas;
    }

    @Override
    public Venta getVentaById(Long id) {
        Venta venta = ventaRepository.findById(id).orElse(null);
        return venta;
    }

    @Override
    public void saveVenta(Venta venta) {

        for(ProductoCantidad productoCantidad : venta.getProductos())
        {
            Producto producto = productoRepository.findById(productoCantidad.getProducto().getCodigo_producto()).orElse(null);

            if(producto != null){
                productoCantidad.setProducto(producto);
            }
        }
        venta.calcularTotal();
        ventaRepository.save(venta);

        for(ProductoCantidad productoCantidad : venta.getProductos())
        {
            Producto producto = productoCantidad.getProducto();
            Double cantidadVendida = productoCantidad.getCantidad();

            Producto productoEnDB = productoRepository.findById(producto.getCodigo_producto()).orElse(null);

            if(productoEnDB.getCantidad_disponible() >= cantidadVendida)
            {
                productoEnDB.setCantidad_disponible(productoEnDB.getCantidad_disponible() - cantidadVendida);
                productoRepository.save(productoEnDB);
            }else{
                throw new RuntimeException("No hay suficiente stock");
            }
        }
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);

    }

    @Override
    public void editVenta(Long id, Venta venta) {
        Venta aux = ventaRepository.findById(id).orElse(null);
        aux.setFecha_venta(venta.getFecha_venta());
        aux.setTotal(venta.getTotal());
        aux.setProductos(venta.getProductos());
        aux.setUncliente(venta.getUncliente());
        aux.setCodigo_venta(id);

        ventaRepository.save(aux);

    }

    @Override
    public List<Producto> ObtenerProductos(Long id_venta) {
        Venta venta = ventaRepository.findById(id_venta).orElse(null);
        List<Producto> productos = new ArrayList<>();
        for(ProductoCantidad productoCantidad : venta.getProductos()){
            Producto producto = productoCantidad.getProducto();
            productos.add(producto);
        }

        return productos;

    }


    @Override
    public Integer ObtenerCantidadVentas(LocalDate fecha_venta) {
        List<Venta> ventas = this.getAllVentas();
        int cant_ventas = 0;

        for(Venta venta : ventas)
        {
            if(venta.getFecha_venta().equals(fecha_venta))
            {
                cant_ventas++;
            }
        }

        return cant_ventas;
    }
    @Override
    public Double ObtenerTotalVendido(LocalDate fecha_venta) {
        List<Venta> ventas = this.getAllVentas();
        double total = 0;

        for(Venta venta : ventas)
        {
            if (venta.getFecha_venta().equals(fecha_venta))
            {
                total += venta.getTotal();
            }
        }

        return total;
    }

}
