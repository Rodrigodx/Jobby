package com.grupo01.jobby.repositories;

import com.grupo01.jobby.model.cadastro.Cadastro;
import com.grupo01.jobby.model.cadastro.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {
}
