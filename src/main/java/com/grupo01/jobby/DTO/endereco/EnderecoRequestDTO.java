package com.grupo01.jobby.DTO.endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoRequestDTO {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private Integer idCidade;

}
