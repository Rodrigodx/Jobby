package com.grupo01.jobby.repositories;

import com.grupo01.jobby.model.cadastro.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissaoRepository extends JpaRepository<Profissao, Integer> {
}
