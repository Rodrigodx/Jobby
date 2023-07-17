package com.grupo01.jobby.model.cadastro;

import com.grupo01.jobby.DTO.habilidade.HabilidadeResquestDTO;
import com.grupo01.jobby.DTO.profissao.ProfissaoResquestDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Habilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    public void atualizar(HabilidadeResquestDTO dadosHabilidade) {
        this.nome = dadosHabilidade.getNome();
    }
}
