package com.grupo01.jobby.model.cadastro;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PretensaoSalarial {

    @Column(name = "vl_min")
    private Double valorMinimo;
    @Column(name = "vl_max")
    private Double valorMaximo;


}
