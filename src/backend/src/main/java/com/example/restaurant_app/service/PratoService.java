package com.example.restaurant_app.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.restaurant_app.entitys.Prato;
import com.example.restaurant_app.repository.PratoRepository;

@Service
public class PratoService {
    private final PratoRepository pratoRepository;

    public PratoService(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    } 

    //metodo para listar os pratos (prioridade: id e pelo nome)
    public List<Prato> listarPratos(){
        Sort sort = Sort.by(Sort.Order.desc("id"));
        // findé um método do Spring Data JPA,retorna uma lista com todos os registros da tabela correspondente à entidade Todo.
        return pratoRepository.findAll(sort);
    }

    public List<Prato> criar(Prato prato){
        pratoRepository.save(prato);
        return listarPratos();
    }

    public List<Prato> atualizar(Long id, Prato prato){

        Prato pratoExistente = pratoRepository.findById(id).orElse(null);

        if ( pratoExistente != null){
            pratoExistente.setNome(prato.getNome());
            pratoExistente.setDescricao(pratoExistente.getDescricao());
            pratoExistente.setPreco(prato.getPreco());

            pratoRepository.save(pratoExistente);
        }
        return listarPratos();
    }    

    public List<Prato> deletar(Long id){
        pratoRepository.deleteById(id);
        return listarPratos();
    }

}
