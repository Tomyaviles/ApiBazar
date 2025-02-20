package com.example.TPIntegradorFinal.Service;

import com.example.TPIntegradorFinal.DTO.VentaDTO;
import com.example.TPIntegradorFinal.Model.Venta;
import com.example.TPIntegradorFinal.Repository.ClienteRepository;
import com.example.TPIntegradorFinal.Repository.ProductoRepository;
import com.example.TPIntegradorFinal.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaDTOService implements IVentaDTOService{

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private IVentaService ventaService;




    @Override
    public VentaDTO getVentaDTOById(Long id) {
        VentaDTO ventaDTO = new VentaDTO();
        Venta venta = ventaRepository.findById(id).orElse(null);
        int cantidad = ventaService.ObtenerCantidadVentas(venta.getFecha_venta());
        Double total = venta.getTotal();
        String nombre_cliente = venta.getUncliente().getNombre();
        String apellido_cliente = venta.getUncliente().getApellido();

        ventaDTO.setCodigo_venta(venta.getCodigo_venta());
        ventaDTO.setTotal(total);
        ventaDTO.setCantProductos(cantidad);
        ventaDTO.setNombre_cliente(nombre_cliente);
        ventaDTO.setApellido_cliente(apellido_cliente);

        return ventaDTO;

    }
}
