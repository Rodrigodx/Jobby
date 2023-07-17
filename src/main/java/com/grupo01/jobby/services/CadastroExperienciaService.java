package com.grupo01.jobby.services;

import com.grupo01.jobby.DTO.experiencia.CadastroExperienciaDTO;
import com.grupo01.jobby.model.cadastro.CadastroExperiencia;
import com.grupo01.jobby.model.cadastro.Profissao;
import com.grupo01.jobby.model.cadastro.exception.EntityNotFoundException;
import com.grupo01.jobby.repositories.CadastroExperienciaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastroExperienciaService {

    private final CadastroExperienciaRepository cadastroExperienciaRepository;
    private final ProfissaoService profissaoService;
    private final ModelMapper modelMapper;

    @Transactional
    public CadastroExperiencia save(CadastroExperienciaDTO dados) {
        Profissao profissao = profissaoService.findById(dados.getProfissaoId());
        CadastroExperiencia cadastroExperiencia1 = new CadastroExperiencia();
        cadastroExperiencia1.setSalario(dados.getSalario());
        cadastroExperiencia1.setEmpregoAtual(dados.getEmpregoAtual());
        cadastroExperiencia1.setDataContratacao(dados.getDataContratacao());
        cadastroExperiencia1.setDatDesligamento(dados.getDataDesligamento());
        cadastroExperiencia1.setRegimeDeContratacaoENUM(dados.getRegimeDeContratacaoENUM());
        cadastroExperiencia1.setEmpresa(dados.getEmpresa());
        cadastroExperiencia1.setProfissao(profissao);

        return cadastroExperienciaRepository.save(cadastroExperiencia1);
    }

    public Page<CadastroExperiencia> findAll(Pageable page) {
        return cadastroExperienciaRepository.findAll(page);
    }

    public CadastroExperiencia findById(Long id) {
        return cadastroExperienciaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Experiencia não cadastrada"));
    }


}
