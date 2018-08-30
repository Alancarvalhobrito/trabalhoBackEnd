package com.trabalho.BackEnd.service;

import com.trabalho.BackEnd.model.Pessoa;
import com.trabalho.BackEnd.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll(){
        return this.pessoaRepository.findAll();
    }
}
