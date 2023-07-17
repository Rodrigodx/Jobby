package com.grupo01.jobby.DTO.cadastro;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CelularDto {

    @NotNull
    private Long numero;

    @NotNull
    private boolean whatsapp;

}
