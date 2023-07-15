package com.grupo01.jobby.repositories;

import com.grupo01.jobby.model.cadastro.Cadastro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

    Page<Cadastro> findAll(Pageable page);

}
