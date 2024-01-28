package com.projeto.dio.projeto_dio.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projeto.dio.projeto_dio.model.Endereco;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    
    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    Endereco consutarCep(@PathVariable("cep") String cep);

}
