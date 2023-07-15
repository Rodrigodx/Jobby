package com.grupo01.jobby.controllers;

import com.grupo01.jobby.model.cadastro.Cadastro;
import com.grupo01.jobby.services.CadastroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/cadastros")
@RequiredArgsConstructor
public class CadastroController {

    private final CadastroService cadastroService;


    @GetMapping
    public ResponseEntity<List<Cadastro>> findAll(){
        return ResponseEntity.ok(cadastroService.findAll());
    }

    @PostMapping
    public ResponseEntity<Cadastro> save(Cadastro cadastro){
        return new ResponseEntity<>(cadastroService.save(cadastro), HttpStatus.CREATED);
    }

}
