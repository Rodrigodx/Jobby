package com.grupo01.jobby.controllers;

import com.grupo01.jobby.model.cadastro.Profissao;
import com.grupo01.jobby.services.ProfissaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/profissoes")
@RequiredArgsConstructor
public class ProfissaoController {

    private final ProfissaoService profissaoService;

    @PostMapping
    public ResponseEntity<Profissao> save(@RequestBody Profissao profissao){
        return new ResponseEntity<>(profissaoService.save(profissao), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Profissao>> findAll(){
        return new ResponseEntity<>(profissaoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profissao> findById(@PathVariable Integer id){
        return new ResponseEntity<>(profissaoService.findById(id), HttpStatus.OK);
    }


}
