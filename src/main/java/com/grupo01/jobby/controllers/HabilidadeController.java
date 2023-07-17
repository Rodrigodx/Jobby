package com.grupo01.jobby.controllers;

import com.grupo01.jobby.DTO.habilidade.HabilidadeResponseDTO;
import com.grupo01.jobby.DTO.habilidade.HabilidadeResquestDTO;
import com.grupo01.jobby.model.cadastro.Habilidade;
import com.grupo01.jobby.services.HabilidadeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/api/habilidades")
public class HabilidadeController {

    private final HabilidadeService habilidadeService;

    @PostMapping
    public ResponseEntity<HabilidadeResponseDTO> save(@Valid @RequestBody HabilidadeResquestDTO dados){
        return new ResponseEntity<>(habilidadeService.save(dados), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Habilidade>> findAll(@PageableDefault(size = 5, sort = { "id" }) Pageable page){
        return new ResponseEntity<>(habilidadeService.findAll(page), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habilidade> findById(@PathVariable Integer id){
        return new ResponseEntity<>(habilidadeService.findById(id), HttpStatus.OK);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Habilidade> update(@PathVariable Integer id, @Valid @RequestBody HabilidadeResquestDTO dadosHabilidade) {
        return new ResponseEntity<>(habilidadeService.update(id, dadosHabilidade), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(habilidadeService.delete(id), HttpStatus.NO_CONTENT);
    }

}
