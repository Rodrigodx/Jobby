package com.grupo01.jobby.DTO.cadastro;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PretensaoSalarialDto {

    @NotNull
    @DecimalMin(value = "0.0")
    private Double valorMinimo;

    @NotNull
    @DecimalMin(value = "0.0")
    private Double valorMaximo;

}
