package com.grupo01.jobby.services;

import com.grupo01.jobby.model.cadastro.Cadastro;
import com.grupo01.jobby.repositories.CadastroRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CadastroService {

    private final CadastroRepository cadastroRepository;

    @ReadOnlyProperty
    public Page<Cadastro> findAll(Pageable page){
        return cadastroRepository.findAll(page);
    }

    @Transactional
    public Cadastro save(Cadastro cadastro){
        return cadastroRepository.save(cadastro);
    }



}
