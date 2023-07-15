package com.grupo01.jobby.services;

import com.grupo01.jobby.model.cadastro.CadastroExperiencia;
import com.grupo01.jobby.model.cadastro.exception.EntityNotFoundException;
import com.grupo01.jobby.repositories.CadastroExperienciaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CadastroExperienciaService {

    private final CadastroExperienciaRepository cadastroExperienciaRepository;

    @Transactional
    public CadastroExperiencia save(CadastroExperiencia dados) {
        return cadastroExperienciaRepository.save(dados);
    }

    public List<CadastroExperiencia> findAll() {
        return cadastroExperienciaRepository.findAll();
    }

    public CadastroExperiencia findById(Long id) {
        return cadastroExperienciaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Experiencia não cadastrada"));
    }


}
