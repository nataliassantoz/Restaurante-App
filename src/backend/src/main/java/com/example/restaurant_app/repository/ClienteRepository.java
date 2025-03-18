package com.example.restaurant_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurant_app.entitys.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Long>{
    
}
