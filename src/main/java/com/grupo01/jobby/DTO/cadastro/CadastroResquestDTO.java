package com.grupo01.jobby.DTO.cadastro;

import com.grupo01.jobby.model.cadastro.Celular;
import com.grupo01.jobby.model.cadastro.Endereco;
import com.grupo01.jobby.model.cadastro.PretencaoSalarial;
import com.grupo01.jobby.model.cadastro.Profissao;
import com.grupo01.jobby.model.cadastro.enums.SexoEnum;
import lombok.Data;

import java.util.List;

@Data
public class CadastroResquestDTO {


    private Integer id;

    private String nome;


    private SexoEnum sexoEnum;


    private PretencaoSalarial pretencaoSalarial;


    private Celular celularPessoal;

    private Celular celularProfissional;


    private Endereco endereco;


    private Profissao profissao;


    private List<String> habilidades;

}
