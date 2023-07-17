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

   // 4 - Contar quantos candidatos possuem a habilidade JAVA

   // 5 - Consulta que devolve cadastros sem habilidades vinculadas
   @Query("SELECT c FROM Cadastro c WHERE EXISTS (SELECT 1 FROM c.habilidades h)")
   List<Cadastro> buscarCandidatosComHabilidade();

   // 6 - Consulta que devolve candidatos por sexo e estado
   @Query("SELECT ca FROM Cadastro ca JOIN ca.endereco.cidade ci WHERE ca.sexoEnum = :sexo AND ci.sigla = :sigla")
   List<Cadastro> candidatosPorSexoEEstado(@Param("sexo") SexoEnum nome, @Param("sigla") String sigla);

   // 7 - Agrupar por profissão e contar quantos profissionais que moram na cidade de nome SÃO PAULO

   // 8 - Selecionar candidatos que registram experiências com data de contratação entre 01/01/202 a 31/12/2023

   // 9 - Selecionar candidatos que trabalharam na empresa MICROSOFT

   // 10 Selecionar candidatos que AINDA trabalham na empresa MICROSOFT

   // 11 -Consulta que devolve candidatos que estão empregados atualmente
   @Query("SELECT c FROM Cadastro c JOIN c.experiencias e WHERE e.empregoAtual = true")
   List<Cadastro> candidatosComTrabalho();

   // 12 - Criar uma consulta que retorne todos os candidatos e nome da sua profissão correspondentemente
   Page<Cadastro> findAll(Pageable page);

   // 13 - Criar uma consulta que retorne todos os candidatos e nome da sua profissão onde o id da profissão corresponda ao registro ANALISTA DE SISTEMAS
   @Query("SELECT c, p.name FROM Cadastro c JOIN c.Profissao p WHERE p.name = :nomeProfissao")
   List<Cadastro> cadastrosPorProfissao(@Param("nomeProfissao") String nomeProfissao);

   // 14 - Consulta que conte a quantidade de profissionais por profissão
   @Query("SELECT p.name, COUNT(c) FROM Cadastro c JOIN c.Profissao p GROUP BY p.id, p.name")
   List<Object[]> countCadastroByProfissao();

   // 15 - Criar uma consulta que retorne os candidatos ordenados por profissão e salário máximo de forma decrescente
   @Query("SELECT c FROM Cadastro c JOIN c.Profissao p ORDER BY p.name, c.pretencaoSalarial.valorMaximo DESC")
   List<Cadastro> buscarCandidatosOrdenadosPorProfissaoESalario();

}
