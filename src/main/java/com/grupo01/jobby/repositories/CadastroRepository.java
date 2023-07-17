package com.grupo01.jobby.repositories;

import com.grupo01.jobby.model.cadastro.Cadastro;
import com.grupo01.jobby.model.cadastro.enums.SexoEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

   Page<Cadastro> findAll(Pageable page);

   // Consulta que conte a quantidade de profissionais por profissão
   @Query("SELECT p.name, COUNT(c) FROM Cadastro c JOIN c.Profissao p GROUP BY p.id, p.name")
   List<Object[]> countCadastroByProfissao();

   // Consulta que devolve cadastros sem habilidades vinculadas
   @Query("SELECT c FROM Cadastro c WHERE EXISTS (SELECT 1 FROM c.habilidades h)")
   List<Cadastro> buscarCandidatosComHabilidade();


   // Consulta que devolve candidatos que estão empregados atualmente
   @Query("SELECT c FROM Cadastro c JOIN c.experiencias e WHERE e.empregoAtual = true")
   List<Cadastro> candidatosComTrabalho();

   // Consulta que devolve candidatos por sexo e estado
   @Query("SELECT ca FROM Cadastro ca JOIN ca.endereco.cidade ci WHERE ca.sexoEnum = :sexo AND ci.sigla = :sigla")
   List<Cadastro> candidatosPorSexoEEstado(@Param("sexo") SexoEnum nome, @Param("sigla") String sigla);
}
