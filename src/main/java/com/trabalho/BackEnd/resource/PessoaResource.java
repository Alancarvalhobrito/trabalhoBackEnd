package com.trabalho.BackEnd.resource;

import com.trabalho.BackEnd.model.Pessoa;
import com.trabalho.BackEnd.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> findAll(){
        return pessoaService.findAll();
    }

    @GetMapping("/{id}")
    public Pessoa findById(@PathVariable Integer id){
        return pessoaService.findById(id);
    }

    @PostMapping
    public Pessoa save(@RequestBody Pessoa pessoa){
        return pessoaService.save(pessoa);
    }

    @PutMapping("/{id}")
    public Pessoa update(@PathVariable Integer id, @RequestBody Pessoa pessoa){
        return pessoaService.update(id, pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        pessoaService.delete(id);
    return ResponseEntity.noContent().build();
    }

}
