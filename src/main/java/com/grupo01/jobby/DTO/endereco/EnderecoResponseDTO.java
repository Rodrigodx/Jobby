package com.grupo01.jobby.DTO.endereco;

import com.grupo01.jobby.DTO.cidade.CidadeResponseDTO;
import com.grupo01.jobby.model.cadastro.Cidade;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;


@Data
public class EnderecoResponseDTO {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private CidadeResponseDTO cidade;

}
