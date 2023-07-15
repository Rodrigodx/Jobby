package com.grupo01.jobby.DTO.endereco;

import com.grupo01.jobby.model.cadastro.Cidade;
import lombok.Data;


@Data
public class EnderecoRequestDTO {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private Cidade cidade;

}
