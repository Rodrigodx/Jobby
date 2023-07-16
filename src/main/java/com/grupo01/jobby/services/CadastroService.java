package com.grupo01.jobby.services;

import com.grupo01.jobby.DTO.cadastro.CadastroResquestDTO;
import com.grupo01.jobby.model.cadastro.Cadastro;
import com.grupo01.jobby.model.cadastro.exception.EntityNotFoundException;
import com.grupo01.jobby.repositories.CadastroRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CadastroService {

    private final CadastroRepository cadastroRepository;

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
    public Cadastro save(Cadastro cadastro){
        return cadastroRepository.save(cadastro);
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
