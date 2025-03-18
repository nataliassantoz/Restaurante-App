package com.example.restaurant_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.restaurant_app.entitys.Pedido;
import com.example.restaurant_app.repository.PedidoRepository;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    //criar pedido
    public Pedido criar(Pedido pedido){
       return pedidoRepository.save(pedido);
    }

    public Pedido atualizar(Long id, Pedido pedidoAtualizado){
        // O Optional nos força a verificar se o pedido existe antes de tentar usá-lo.
        //etorna um Optional<Pedido>, que pode conter um pedido ou estar vazio.
        Optional<Pedido>  pedidoOptional = pedidoRepository.findById(id); 

        if (pedidoOptional.isPresent()){// Verifica se o pedido existe o com isPresent()

            Pedido pedidoExistente = pedidoOptional.get(); // Obtém o pedido existente
            pedidoExistente.setCliente(pedidoAtualizado.getCliente());
            pedidoExistente.setPrato(pedidoAtualizado.getPrato());
            pedidoExistente.setStatus(pedidoAtualizado.getStatus());

            return pedidoRepository.save(pedidoExistente);
        }
        return null;
    }

    public Pedido buscarPedidoId(long id){
        return  pedidoRepository.findById(id).orElse(null);
    }

    public void deletarPedido(Long id){
       pedidoRepository.deleteById(id);
    }

    public Pedido atualizarStatus(Long id, String novoStatus){
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if( pedidoOptional.isPresent()){
            Pedido pedido = pedidoOptional.get();
            pedido.setStatus(novoStatus);
            return pedidoRepository.save(pedido);
        }
        return null;
    }

    public List<Pedido> listarPedidosPorStatus(String status) {
        return pedidoRepository.findByStatus(status);
    }
}
