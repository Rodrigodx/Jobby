package com.grupo01.jobby.controllers;


import com.grupo01.jobby.model.cadastro.Cidade;
import com.grupo01.jobby.services.CidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/cidade")
@RequiredArgsConstructor
public class CidadeController {
    private final CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<Cidade> save(@RequestBody Cidade cidade) {
        return new ResponseEntity<>(cidadeService.save(cidade), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Cidade> findById(@RequestBody Integer id) {
        return new ResponseEntity<>(cidadeService.buscar(1), HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(@RequestBody Integer id) {

        return new ResponseEntity<>(cidadeService.delete(id), HttpStatus.ACCEPTED);
    }

}
