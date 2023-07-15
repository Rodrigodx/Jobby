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
    private LocalDate dataContratacao;
    private Date datDesligamento;

    @Enumerated(EnumType.STRING)
    private RegimeDeContratacaoENUM regimeDeContratacaoENUM;

    private String empresa;

}
