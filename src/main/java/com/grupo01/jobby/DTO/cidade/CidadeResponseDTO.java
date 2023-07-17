package com.grupo01.jobby.DTO.cidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class CidadeResponseDTO {

    String nome;
    String estado;
    String sigla;
}
