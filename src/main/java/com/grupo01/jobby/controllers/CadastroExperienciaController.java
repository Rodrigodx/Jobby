package com.grupo01.jobby.controllers;

import com.grupo01.jobby.model.cadastro.CadastroExperiencia;
import com.grupo01.jobby.services.CadastroExperienciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/experiencia")
@RequiredArgsConstructor
public class CadastroExperienciaController {

    private final CadastroExperienciaService cadastroExperienciaService;

    @GetMapping
    public ResponseEntity<List<CadastroExperiencia>> findAll(){
        return new ResponseEntity<>(cadastroExperienciaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadastroExperiencia> findAllById(@PathVariable Long id){
        return new ResponseEntity<>(cadastroExperienciaService.findById(id), HttpStatus.OK);
    }

}
