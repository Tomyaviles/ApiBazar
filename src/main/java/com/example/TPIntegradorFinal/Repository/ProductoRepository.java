package com.example.TPIntegradorFinal.Repository;

import com.example.TPIntegradorFinal.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
