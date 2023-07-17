package com.grupo01.jobby.controllers;

import com.grupo01.jobby.DTO.cadastro.CadastroResponseDTO;
import com.grupo01.jobby.DTO.cadastro.CadastroRequestDTO;
import com.grupo01.jobby.model.cadastro.Cadastro;
import com.grupo01.jobby.services.CadastroService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/cadastros")
@RequiredArgsConstructor
public class CadastroController {

    private final CadastroService cadastroService;


    @GetMapping
    public ResponseEntity<Page<Cadastro>> findAll(@PageableDefault(size = 5, sort = { "id" }) Pageable page){
        return ResponseEntity.ok(cadastroService.findAll(page));
    }

    @PostMapping
    public ResponseEntity<CadastroResponseDTO> save(@RequestBody CadastroRequestDTO dados){
        return new ResponseEntity<>(cadastroService.save(dados), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/id")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        cadastroService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
