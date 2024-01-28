package com.projeto.dio.projeto_dio.service;


import com.projeto.dio.projeto_dio.model.Cliente;

public interface ClienteService {
    
    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id );


}
