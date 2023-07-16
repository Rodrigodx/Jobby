package com.grupo01.jobby.model.cadastro;

import com.grupo01.jobby.model.cadastro.enums.SexoEnum;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Entity
@Data
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(length = 60, nullable = false)
    private String nome;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private SexoEnum sexoEnum;

    @Embedded
    private PretencaoSalarial pretencaoSalarial;

    @Embedded
    private Celular celularPessoal;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="numero",
                    column=@Column(name="cel_num_pess")),
            @AttributeOverride(name="whatsapp",
                    column=@Column(name="cel_is_whats_pess"))
    })
    private Celular celularProfissional;

    @Embedded
    private Endereco endereco;

    @Column(name = "id_profissao")
    private Integer idProfissao;

    @ElementCollection
    @CollectionTable(name="tab_cad_habilidade",
            joinColumns=@JoinColumn(name = "cad_id"))
    @Column(name="nm_habil")
    private List<String> habilidades;

}
