package com.grupo01.jobby.services;

import com.grupo01.jobby.model.cadastro.Profissao;
import com.grupo01.jobby.repositories.ProfissaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfissaoService {

    private final ProfissaoRepository profissaoRepository;
    @Transactional
    public Profissao save (Profissao profissao){
        return profissaoRepository.save(profissao);
    }


    public List<Profissao> findAll(){
        return profissaoRepository.findAll();
    }

    public Profissao findById(Integer id){
        return profissaoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Profissão com id = " + id + " não foi cadastrada."));
    }


    @Transactional
    public Profissao update(Integer id, Profissao dadosProfissao) {
        Profissao profissao = findById(id);
        profissao.atualizar(dadosProfissao);

        return profissaoRepository.save(profissao);
    }

    @Transactional
    public boolean delete(Integer id) {
        if (profissaoRepository.existsById(id)) {
            profissaoRepository.deleteById(id);

            return true;
        }

        return false;
    }
}
