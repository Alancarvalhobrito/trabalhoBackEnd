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

    public Pessoa findById(Integer id){
        return this.pessoaRepository.findById(id).orElse(null);
    }

    public Pessoa save(Pessoa pessoa){
        return this.pessoaRepository.save(pessoa);
    }

    public Pessoa update(Integer id, Pessoa pessoa){
        Pessoa pessoaEncontrada = findById(id);
        if (pessoaEncontrada != null){
            pessoaEncontrada = pessoa;
            pessoaEncontrada.setId(id);
            return save(pessoaEncontrada);
        }
        return null;
    }

    public void delete(Integer id){
        Pessoa pessoaEncontrada = findById(id);
        if (pessoaEncontrada != null){
            this.pessoaRepository.delete(pessoaEncontrada);
        }
    }

}
