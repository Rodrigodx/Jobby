package com.grupo01.jobby.model.cadastro;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Endereco {

    private String cep;
    private String logradouro;

}
