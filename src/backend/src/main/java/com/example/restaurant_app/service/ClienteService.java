package com.example.restaurant_app.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.restaurant_app.entitys.Cliente;
import com.example.restaurant_app.repository.ClienteRepository;
import com.example.restaurant_app.repository.PedidoRepository;


@Service
public class ClienteService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository, PedidoRepository pedidoRepository) {
        this.clienteRepository = clienteRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public List<Cliente> listarCliente(){
        Sort sort = Sort.by(Sort.Order.desc("id"));
        return  clienteRepository.findAll(sort);
    }

    public Cliente criar(Cliente cliente){
         return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Cliente cliente){
        Cliente clienteExistente = clienteRepository.findById(cliente.getId()).orElse(null);

        if (clienteExistente != null){
            clienteExistente.setNome(cliente.getNome());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setTelefone(cliente.getTelefone());
        }
        return clienteRepository.save(clienteExistente);
    }
}
