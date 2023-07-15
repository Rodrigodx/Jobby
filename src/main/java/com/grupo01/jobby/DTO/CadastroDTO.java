package com.grupo01.jobby.DTO;

import com.grupo01.jobby.model.cadastro.*;
import lombok.Data;


import java.util.List;

@Data
public class CadastroDTO {


    private Integer id;

    private String nome;


    private Sexo sexo;


    private PretencaoSalarial pretencaoSalarial;


    private Celular celularPessoal;

    private Celular celularProfissional;


    private Endereco endereco;


    private Profissao profissao;


    private List<String> habilidades;

}
