package com.example.TPIntegradorFinal.Repository;

import com.example.TPIntegradorFinal.Model.Cliente;
import com.example.TPIntegradorFinal.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {


}
