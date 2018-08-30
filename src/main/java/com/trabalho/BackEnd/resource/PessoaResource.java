package com.trabalho.BackEnd.resource;

import com.trabalho.BackEnd.model.Pessoa;
import com.trabalho.BackEnd.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> finfAll(){
        return pessoaService.findAll();
    }
}
