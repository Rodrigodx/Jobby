package com.grupo01.jobby.repositories;

import com.grupo01.jobby.model.cadastro.CadastroExperiencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroExperienciaRepository extends JpaRepository<CadastroExperiencia, Long> {

    Page<CadastroExperiencia> findAll(Pageable page);

}
