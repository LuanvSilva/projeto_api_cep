package com.projeto.dio.projeto_dio.service.impl;

import org.springframework.stereotype.Service;

import com.projeto.dio.projeto_dio.model.Cliente;
import com.projeto.dio.projeto_dio.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Override
    public Iterable<Cliente> buscarTodos() {

        return null;
        
    }

    @Override
    public Cliente buscarPorId(Long id) {
        
        return null;    }

    @Override
    public void inserir(Cliente cliente) {
        
        throw new UnsupportedOperationException("Unimplemented method 'inserir'");
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void deletar(Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }



    
}