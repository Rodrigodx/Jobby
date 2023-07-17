package com.grupo01.jobby.controllers;

import com.grupo01.jobby.DTO.profissao.ProfissaoResquestDTO;
import com.grupo01.jobby.model.cadastro.Cidade;
import com.grupo01.jobby.services.CidadeService;
import com.grupo01.jobby.services.ProfissaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/inicial")
@RequiredArgsConstructor
public class ControleInicial

{
    private final CidadeService cidadeService;


    private final ProfissaoService profissaoService;


    @PostMapping
   public void save(){
        ProfissaoResquestDTO p = new ProfissaoResquestDTO();
        p.setName("Programador");
        ProfissaoResquestDTO p2 = new ProfissaoResquestDTO();
        p.setName("Professor");
        ProfissaoResquestDTO p3 = new ProfissaoResquestDTO();
        p.setName("corredor");
        ProfissaoResquestDTO p4 = new ProfissaoResquestDTO();
        p.setName("Político");
        profissaoService.save(p);
        profissaoService.save(p2);
        profissaoService.save(p3);
        profissaoService.save(p4);
        Cidade c = new Cidade();
        c.setNome("Maceio");
        Cidade c1 = new Cidade();
        c.setNome("Macapá");
        Cidade c2 = new Cidade();
        c.setNome("Manaus");
        cidadeService.save(c);
        cidadeService.save(c1);
        cidadeService.save(c2);
    }


}
