package com.grupo01.jobby.services;

import com.grupo01.jobby.model.cadastro.Cadastro;
import com.grupo01.jobby.repositories.CadastroRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CadastroService {

    private final CadastroRepository cadastroRepository;

    @ReadOnlyProperty
    public List<Cadastro> findAll(){
        return cadastroRepository.findAll();
    }

    @Transactional
    public Cadastro save(Cadastro cadastro){
        return cadastroRepository.save(cadastro);
    }



}
