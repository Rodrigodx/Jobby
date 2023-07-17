package com.grupo01.jobby.model.cadastro;

import com.grupo01.jobby.model.cadastro.enums.RegimeDeContratacaoENUM;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class CadastroExperiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double salario;
    private boolean empregoAtual;

    @Column(columnDefinition = "DATE")
    private LocalDate dataContratacao;

    @Column(columnDefinition = "DATE")
    private Date datDesligamento;

    @Enumerated(EnumType.STRING)
    private RegimeDeContratacaoENUM regimeDeContratacaoENUM;

    private String empresa;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Profissao profissao;

}
