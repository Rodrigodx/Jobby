package com.grupo01.jobby.DTO.experiencia;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CadastroExperienciaRequestDTO {

    @NotNull
    private Long idExperiencia;

}
