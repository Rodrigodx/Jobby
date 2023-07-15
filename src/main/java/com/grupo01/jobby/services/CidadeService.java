package com.grupo01.jobby.services;

import com.grupo01.jobby.model.cadastro.Cidade;
import com.grupo01.jobby.model.cadastro.exception.EntityNotFoundException;
import com.grupo01.jobby.repositories.CidadeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CidadeService {
    @Autowired
    private final CidadeRepository cidadeRepository;

    @Transactional
    public Cidade save(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    @Transactional
    public Cidade buscar(Integer id) {
        return cidadeRepository.getById(id);
    }

    @Transactional
    public Boolean delete(Integer id) {
        Optional<Cidade> cidadeOptional = Optional.ofNullable(cidadeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cidade com id = " + id + " não foi cadastrado.")));
        if (cidadeOptional.isEmpty()) {
            return false;

        } else {
            Cidade cidade = new Cidade();
            BeanUtils.copyProperties(cidadeOptional.get(), cidade);

            cidadeRepository.delete(cidade);
            return true;
        }
    }
}
