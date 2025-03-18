package com.example.restaurant_app.entitys;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    private List<Prato> pratos = new ArrayList<>();
    //@ManyToOne: Indica que o relacionamento é "muitos para um". 
    //Isso significa que, para a classe Pedido, você pode ter muitos pedidos associados a um único cliente ou prato.
    @ManyToOne
    private Cliente cliente;
    @Enumerated(EnumType.ORDINAL)
    private StatusPedido status;
    
    public Pedido( List<Prato> pratos, Cliente cliente) {
        this.pratos = pratos;
        this.cliente = cliente;
        this.status = StatusPedido.CRIADO;
    }

    public void prepararPedido(){
        if (this.status == StatusPedido.CRIADO){
            this.status = StatusPedido.EM_PREPARO;
        }
    }
    public void finalizarPedido(){
        if (this.status == StatusPedido.EM_PREPARO){
            this.status = StatusPedido.FINALIZADO;
        }
    }

    public void fecharPedido(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    


    
}
