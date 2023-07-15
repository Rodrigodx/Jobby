package com.grupo01.jobby.DTO.cadastro;

import com.grupo01.jobby.DTO.endereco.EnderecoResponseDTO;
import com.grupo01.jobby.model.cadastro.*;
import com.grupo01.jobby.model.cadastro.enums.SexoEnum;
import lombok.Data;


import java.util.List;

@Data
public class CadastroResponseDTO {


    private Integer id;

    private String nome;


    private SexoEnum sexoEnum;


    private PretencaoSalarial pretencaoSalarial;


    private Celular celularPessoal;

    private Celular celularProfissional;


    private EnderecoResponseDTO endereco;


    private Profissao profissao;


    private List<String> habilidades;

}
