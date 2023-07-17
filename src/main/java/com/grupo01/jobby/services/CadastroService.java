package com.grupo01.jobby.services;

<<<<<<< HEAD
import com.grupo01.jobby.DTO.cadastro.CadastroResquestDTO;
import com.grupo01.jobby.model.cadastro.Cadastro;
import com.grupo01.jobby.model.cadastro.exception.EntityNotFoundException;
=======
import com.grupo01.jobby.DTO.cadastro.CadastroResponseDTO;
import com.grupo01.jobby.DTO.cadastro.CadastroRequestDTO;
import com.grupo01.jobby.model.cadastro.Cadastro;
import com.grupo01.jobby.model.cadastro.CadastroExperiencia;
import com.grupo01.jobby.model.cadastro.Cidade;
import com.grupo01.jobby.model.cadastro.Profissao;
>>>>>>> 6ed52a91f2add44458433cfd205b1b0f86ede160
import com.grupo01.jobby.repositories.CadastroRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


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

    @ReadOnlyProperty
    public Cadastro findById(Integer id){
        return cadastroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cadastro com o id: " + id + "não foi encontrado"));
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

    @Transactional
    public Cadastro update(Integer id, CadastroResquestDTO dadosCadastro) {
        Cadastro cadastro = findById(id);
        cadastro.atualizar(dadosCadastro);

        return cadastroRepository.save(cadastro);
    }

    @Transactional
    public boolean delete(Integer id) {
        if (cadastroRepository.existsById(id)) {
            cadastroRepository.deleteById(id);

            return true;
        }

        return false;
    }


}
