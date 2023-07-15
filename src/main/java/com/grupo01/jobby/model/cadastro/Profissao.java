package com.grupo01.jobby.model.cadastro;

import com.grupo01.jobby.DTO.profissao.ProfissaoResponseDTO;
import com.grupo01.jobby.DTO.profissao.ProfissaoResquestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Profissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public void atualizar(ProfissaoResquestDTO dadosProfissao) {
        this.name = dadosProfissao.getName();
    }
}
