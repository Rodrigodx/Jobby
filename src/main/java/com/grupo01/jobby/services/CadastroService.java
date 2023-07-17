package com.grupo01.jobby.services;

import com.grupo01.jobby.DTO.cadastro.CadastroResponseDTO;
import com.grupo01.jobby.DTO.cadastro.CadastroRequestDTO;
import com.grupo01.jobby.model.cadastro.Cadastro;
import com.grupo01.jobby.model.cadastro.CadastroExperiencia;
import com.grupo01.jobby.model.cadastro.Cidade;
import com.grupo01.jobby.model.cadastro.Profissao;
import com.grupo01.jobby.model.cadastro.enums.SexoEnum;
import com.grupo01.jobby.repositories.CadastroRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CadastroService {

    private final CadastroRepository cadastroRepository;
    private final CidadeService cidadeService;
    private final ProfissaoService profissaoService;
    private final CadastroExperienciaService cadastroExperienciaService;
    private final ModelMapper modelMapper;

    @ReadOnlyProperty
    public Page<Cadastro> findAll(Pageable page){
        return cadastroRepository.findAll(page);
    }

    @Transactional
    public CadastroResponseDTO save(CadastroRequestDTO dados){
        Cidade cidade = cidadeService.buscar(dados.getEndereco().getIdCidade());
        Profissao profissao = profissaoService.findById(dados.getIdProfissao());
        List<CadastroExperiencia> experiencias = dados.getExperiencias().stream().map(e -> cadastroExperienciaService.findById(e.getIdExperiencia())).toList();

        Cadastro cadastro = modelMapper.map(dados, Cadastro.class);

        cadastro.getEndereco().setCidade(cidade);
        cadastro.setProfissao(profissao);
        cadastro.setExperiencias(experiencias);

        cadastroRepository.save(cadastro);

        return modelMapper.map(cadastro, CadastroResponseDTO.class);
    }

    public List<Object[]> contarPorProfissoes() {
        return cadastroRepository.countCadastroByProfissao();
    }

    public List<Cadastro> buscarComHabilidade() {
        return cadastroRepository.buscarCandidatosComHabilidade();
    }

    public List<Cadastro> candidatosComTrabalho() {
        return cadastroRepository.candidatosComTrabalho();
    }

    public List<Cadastro> candidatosPorSexoEEstado(SexoEnum sexo, String sigla) {
        return cadastroRepository.candidatosPorSexoEEstado(sexo, sigla);
    }
}
