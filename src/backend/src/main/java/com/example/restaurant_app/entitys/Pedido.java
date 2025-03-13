package com.example.restaurant_app.entitys;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Prato prato;
    //@ManyToOne: Indica que o relacionamento é "muitos para um". 
    //Isso significa que, para a classe Pedido, você pode ter muitos pedidos associados a um único cliente ou prato.
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private String status;
    
    public Pedido(Long id, Prato prato, Cliente cliente, String status) {
        this.id = id;
        this.prato = prato;
        this.cliente = cliente;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
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
