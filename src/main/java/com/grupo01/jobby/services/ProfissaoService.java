package com.grupo01.jobby.services;

import com.grupo01.jobby.model.cadastro.Profissao;
import com.grupo01.jobby.repositories.ProfissaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfissaoService {

    private final ProfissaoRepository profissaoRepository;
    @Transactional
    public Profissao save (Profissao profissao){
        return profissaoRepository.save(profissao);
    }

}
