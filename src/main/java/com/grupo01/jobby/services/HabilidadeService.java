package com.grupo01.jobby.services;

import com.grupo01.jobby.DTO.habilidade.HabilidadeResponseDTO;
import com.grupo01.jobby.DTO.habilidade.HabilidadeResquestDTO;
import com.grupo01.jobby.model.cadastro.Habilidade;
import com.grupo01.jobby.model.cadastro.exception.EntityNotFoundException;
import com.grupo01.jobby.repositories.HabilidadeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HabilidadeService {

    private final HabilidadeRepository habilidadeRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public HabilidadeResponseDTO save (HabilidadeResquestDTO dados){
        Habilidade habilidade = modelMapper.map(dados, Habilidade.class);
        habilidadeRepository.save(habilidade);

        return modelMapper.map(habilidade, HabilidadeResponseDTO.class);
    }

    @ReadOnlyProperty
    public Page<Habilidade> findAll(Pageable page){
        return habilidadeRepository.findAll(page);
    }

    @ReadOnlyProperty
    public Habilidade findById(Integer id){
        return habilidadeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Profissão com id = " + id + " não foi cadastrada."));
    }
    @Transactional
    public Habilidade update(Integer id, HabilidadeResquestDTO dadosHabilidade) {
        Habilidade habilidade = findById(id);
        habilidade.atualizar(dadosHabilidade);

        return habilidadeRepository.save(habilidade);
    }

    @Transactional
    public boolean delete(Integer id) {
        if (habilidadeRepository.existsById(id)) {
            habilidadeRepository.deleteById(id);

            return true;
        }

        return false;
    }


}
