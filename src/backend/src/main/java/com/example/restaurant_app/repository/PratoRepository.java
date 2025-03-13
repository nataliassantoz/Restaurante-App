package com.example.restaurant_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurant_app.entitys.Prato;

public interface  PratoRepository extends JpaRepository<Prato, Long>{
    
}
