package com.grupo01.jobby.repositories;

import com.grupo01.jobby.model.cadastro.CadastroExperiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadastroExperienciaRepository extends JpaRepository<CadastroExperiencia, Long> {

    List<CadastroExperiencia> findAll();

}
