package com.grupo01.jobby.services;

import com.grupo01.jobby.DTO.experiencia.CadastroExperienciaDTO;
import com.grupo01.jobby.model.cadastro.CadastroExperiencia;
import com.grupo01.jobby.model.cadastro.Profissao;
import com.grupo01.jobby.model.cadastro.exception.EntityNotFoundException;
import com.grupo01.jobby.repositories.CadastroExperienciaRepository;
import com.grupo01.jobby.repositories.ProfissaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CadastroExperienciaService {

    private final CadastroExperienciaRepository cadastroExperienciaRepository;
    private final ProfissaoService profissaoService;
    private final ModelMapper modelMapper;

    @Transactional
    public CadastroExperiencia save(CadastroExperienciaDTO dados) {
        Profissao profissao = profissaoService.findById(dados.getProfissaoId());
        CadastroExperiencia cadastroExperiencia = modelMapper.map(dados, CadastroExperiencia.class);
        cadastroExperiencia.setProfissao(profissao);

        return cadastroExperienciaRepository.save(cadastroExperiencia);
    }

    public List<CadastroExperiencia> findAll() {
        return cadastroExperienciaRepository.findAll();
    }

    public CadastroExperiencia findById(Long id) {
        return cadastroExperienciaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Experiencia não cadastrada"));
    }


}
