package com.trabalho.BackEnd.service;

import com.trabalho.BackEnd.dto.PessoaDTO;
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

    public Pessoa save(PessoaDTO pessoaDTO){
        return this.pessoaRepository.save(converterPessoaDTO(pessoaDTO));
    }

    public Pessoa update(Integer id, PessoaDTO pessoaDTO){
        Pessoa pessoaEncontrada = findById(id);
        if (pessoaEncontrada != null){
            pessoaEncontrada.setId(id);
            pessoaEncontrada.setNome(pessoaDTO.getNome());
            pessoaEncontrada.setCpf(pessoaDTO.getCpf());
            pessoaEncontrada.setIdade(pessoaDTO.getIdade());
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

    private Pessoa converterPessoaDTO(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setIdade(pessoaDTO.getIdade());
        return pessoa;
    }

}
