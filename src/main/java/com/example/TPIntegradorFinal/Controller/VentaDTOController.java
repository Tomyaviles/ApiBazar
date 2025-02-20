package com.example.TPIntegradorFinal.Controller;

import com.example.TPIntegradorFinal.DTO.VentaDTO;
import com.example.TPIntegradorFinal.Service.IVentaDTOService;
import com.example.TPIntegradorFinal.Service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaDTOController {

    @Autowired
    private IVentaDTOService ventaDTOService;

    @GetMapping("/ventas/dto/{id_venta}")
    public VentaDTO getVentaDTO(@PathVariable Long id_venta) {
        return ventaDTOService.getVentaDTOById(id_venta);
    }
}
