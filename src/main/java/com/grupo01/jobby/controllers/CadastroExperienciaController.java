package com.grupo01.jobby.controllers;

import com.grupo01.jobby.DTO.experiencia.CadastroExperienciaDTO;
import com.grupo01.jobby.DTO.profissao.ProfissaoResquestDTO;
import com.grupo01.jobby.model.cadastro.CadastroExperiencia;
import com.grupo01.jobby.model.cadastro.Profissao;
import com.grupo01.jobby.services.CadastroExperienciaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiencia")
@RequiredArgsConstructor
public class CadastroExperienciaController {

    private final CadastroExperienciaService cadastroExperienciaService;

    @PostMapping
    public ResponseEntity<CadastroExperiencia> save(@Valid @RequestBody CadastroExperienciaDTO dados){
        return new ResponseEntity<>(cadastroExperienciaService.save(dados), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CadastroExperiencia>> findAll(){
        return new ResponseEntity<>(cadastroExperienciaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadastroExperiencia> findAllById(@PathVariable Long id){
        return new ResponseEntity<>(cadastroExperienciaService.findById(id), HttpStatus.OK);
    }

}
