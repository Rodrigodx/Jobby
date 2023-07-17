package com.grupo01.jobby.controllers;

import com.grupo01.jobby.DTO.cadastro.CadastroResponseDTO;
import com.grupo01.jobby.DTO.cadastro.CadastroRequestDTO;
import com.grupo01.jobby.model.cadastro.Cadastro;
import com.grupo01.jobby.model.cadastro.enums.SexoEnum;
import com.grupo01.jobby.services.CadastroService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

    @GetMapping("/count-profissao")
    public ResponseEntity<List<Object[]>> contarPorProfissao(){
        return ResponseEntity.ok(cadastroService.contarPorProfissoes());
    }

    @GetMapping("/com-habilidade")
    public ResponseEntity<List<Cadastro>> buscarComHabilidade(){
        return ResponseEntity.ok(cadastroService.buscarComHabilidade());
    }

    @GetMapping("/trabalhando")
    public ResponseEntity<List<Cadastro>> candidatosComTrabalho(){
        return ResponseEntity.ok(cadastroService.candidatosComTrabalho());
    }

    @GetMapping("/sexo-e-uf")
    public ResponseEntity<List<Cadastro>> candidatosPorSexoEEstado(@RequestParam(value = "sexo",
            required = true) SexoEnum sexo, @RequestParam(value = "sigla",
            required = true, defaultValue = "") String sigla) {
        return ResponseEntity.ok(cadastroService.candidatosPorSexoEEstado(sexo, sigla));
    }

    @GetMapping("/por-profissao")
    public ResponseEntity<List<Cadastro>> cadastrosPorProfissao(@RequestParam(value = "nomeProfissao") String nomeProfissao) {
        return ResponseEntity.ok(cadastroService.cadastrosPorProfissao(nomeProfissao));
    }

    @GetMapping("/profissao-salario")
    public ResponseEntity<List<Cadastro>> buscarCandidatosOrdenadosPorProfissaoESalario() {
        return ResponseEntity.ok(cadastroService.buscarCandidatosOrdenadosPorProfissaoESalario());
    }

    @GetMapping("/habilidade")
    public ResponseEntity<Long> contarCandidatosComHabilidade(@RequestParam(value = "nomeHabilidade") String nomeHabilidade) {
        return ResponseEntity.ok(cadastroService.contarCandidatosComHabilidade(nomeHabilidade));
    }

    @GetMapping("/experiencia-data")
    public ResponseEntity<List<Cadastro>> candidatosComExperienciaPorData (
            @RequestParam("dataInicio") LocalDate dataInicio,
            @RequestParam("dataFim") LocalDate dataFim) {
        return ResponseEntity.ok(cadastroService.candidatosComExperienciaPorData(dataInicio, dataFim));
    }

    @GetMapping("/quantidade-cidade")
    public Long contarProfissionaisPorCidade(@RequestParam("nomeCidade") String nomeCidade) {
        return cadastroService.contarProfissionaisPorCidade(nomeCidade);
    }

    @GetMapping("/empresa-trabalhada")
    public List<Cadastro> candidatoPorEmpresa(@RequestParam("nome") String nome) {
        return cadastroService.candidatoPorEmpresa(nome);
    }

    @GetMapping("/trabalham-empresa")
    public List<Cadastro> candidatoPorExperienciaAtual(@RequestParam("nome") String nome) {
        return cadastroService.candidatoPorExperienciaAtual(nome);
    }
}
