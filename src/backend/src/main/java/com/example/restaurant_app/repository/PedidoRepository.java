package com.example.restaurant_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurant_app.entitys.Pedido;

public interface  PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatus(String status);
    
}
