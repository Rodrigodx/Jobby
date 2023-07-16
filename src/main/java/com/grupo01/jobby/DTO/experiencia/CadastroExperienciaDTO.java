package com.grupo01.jobby.DTO.experiencia;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.grupo01.jobby.model.cadastro.enums.RegimeDeContratacaoENUM;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CadastroExperienciaDTO {

    @NotNull
    private Double salario;

    @NotNull
    private Boolean empregoAtual;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataContratacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDesligamento;

    @NotBlank
    private String empresa;

    @NotNull
    private RegimeDeContratacaoENUM regimeDeContratacaoENUM;

    @NotNull
    private Integer profissaoId;

}
