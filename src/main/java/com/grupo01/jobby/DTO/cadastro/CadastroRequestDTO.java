package com.grupo01.jobby.DTO.cadastro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grupo01.jobby.DTO.endereco.EnderecoRequestDTO;
import com.grupo01.jobby.DTO.experiencia.CadastroExperienciaDTO;
import com.grupo01.jobby.DTO.experiencia.CadastroExperienciaRequestDTO;
import com.grupo01.jobby.model.cadastro.Celular;
import com.grupo01.jobby.model.cadastro.Endereco;
import com.grupo01.jobby.model.cadastro.enums.SexoEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class CadastroRequestDTO {

    @NotBlank
    private String nome;

    @CPF
    private String cpf;

    @NotNull
    private SexoEnum sexoEnum;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull
    private CelularDto celularPessoal;

    @NotNull
    private CelularDto celularProfissional;;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private Integer idProfissao;

    @NotNull
    private EnderecoRequestDTO endereco;

    @NotEmpty
    private List<CadastroExperienciaRequestDTO> experiencias = new ArrayList<>();

    @NotNull
    private PretensaoSalarialDto pretensaoSalarial;

}
