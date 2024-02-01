package com.projeto.dio.projeto_dio.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.dio.projeto_dio.model.Cliente;
import com.projeto.dio.projeto_dio.model.ClienteRepository;
import com.projeto.dio.projeto_dio.model.Endereco;
import com.projeto.dio.projeto_dio.model.EnderecoRepository;
import com.projeto.dio.projeto_dio.service.ClienteService;
import com.projeto.dio.projeto_dio.service.ViaCepService;

/*
*@autor Luan silva
*
/* */

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {

        return clienteRepository.findAll();

    }

    @Override
    public Cliente buscarPorId(Long id) {

        Optional<Cliente> cliente = clienteRepository.findById(id);

        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {

     salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        }

    }


    @Override
    public void deletar(Long id) {

        clienteRepository.deleteById(id);
    }

    
    private void salvarClienteComCep(Cliente cliente){

        String cep = cliente.getEndereco().getCep();

        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {

            Endereco novoEndereco = viaCepService.consutarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

}