package com.example.restaurant_app.entitys;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Prato> pratos;
    //@ManyToOne: Indica que o relacionamento é "muitos para um". 
    //Isso significa que, para a classe Pedido, você pode ter muitos pedidos associados a um único cliente ou prato.
    @ManyToOne
    private Cliente cliente;
    private String status;
    
    public Pedido( List<Prato> pratos, Cliente cliente, String status) {
        this.pratos = pratos;
        this.cliente = cliente;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Prato> getPrato() {
        return pratos;
    }

    public void setPrato(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    


    
}
