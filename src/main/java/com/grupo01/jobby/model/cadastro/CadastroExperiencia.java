package com.grupo01.jobby.model.cadastro;

import com.grupo01.jobby.model.cadastro.enums.RegimeDeContratacaoENUM;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class CadastroExperiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idExperiencia;
    private Double salario;
    private boolean empregoAtual;

    @Column(columnDefinition = "DATE")
    private LocalDate dataContratacao;

    @Column(columnDefinition = "DATE")
    private LocalDate datDesligamento;

    @Enumerated(EnumType.STRING)
    private RegimeDeContratacaoENUM regimeDeContratacaoENUM;

    private String empresa;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "profissao_id")
    private Profissao profissao;

}
