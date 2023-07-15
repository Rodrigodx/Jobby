package com.grupo01.jobby.model.cadastro;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Celular {

    @Column(name = "cel_numero")
    private Long numero;
    @Column(name = "cel_is_numero_whats")
    private boolean whatsapp;

}
