package com.grupo01.jobby.DTO.cadastro;

import com.grupo01.jobby.DTO.endereco.EnderecoResponseDTO;
import com.grupo01.jobby.DTO.profissao.ProfissaoResponseDTO;
import com.grupo01.jobby.model.cadastro.*;
import com.grupo01.jobby.model.cadastro.enums.SexoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CadastroResponseDTO {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private SexoEnum sexoEnum;
    private PretensaoSalarial pretencaoSalarial;
    private CelularDto celularPessoal;
    private CelularDto celularProfissional;
    private EnderecoResponseDTO endereco;
    private ProfissaoResponseDTO profissao;
    private List<CadastroExperiencia> experiencias;
    private List<Habilidade> habilidades;

}
