package com.grupo01.jobby.controllers;

import com.grupo01.jobby.DTO.profissao.ProfissaoResponseDTO;
import com.grupo01.jobby.DTO.profissao.ProfissaoResquestDTO;
import com.grupo01.jobby.model.cadastro.Profissao;
import com.grupo01.jobby.services.ProfissaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<ProfissaoResponseDTO> save(@Valid @RequestBody ProfissaoResquestDTO dados){
        return new ResponseEntity<>(profissaoService.save(dados), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Profissao>> findAll(@PageableDefault(size = 5, sort = { "name" }) Pageable page){
        return new ResponseEntity<>(profissaoService.findAll(page), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profissao> findById(@PathVariable Integer id){
        return new ResponseEntity<>(profissaoService.findById(id), HttpStatus.OK);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Profissao> update(@PathVariable Integer id, @Valid @RequestBody ProfissaoResquestDTO dadosProfissao) {
        return new ResponseEntity<>(profissaoService.update(id, dadosProfissao), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(profissaoService.delete(id), HttpStatus.NO_CONTENT);
    }

}
