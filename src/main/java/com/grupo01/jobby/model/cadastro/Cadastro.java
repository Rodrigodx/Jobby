package com.grupo01.jobby.model.cadastro;

import com.grupo01.jobby.DTO.cadastro.CadastroRequestDTO;
import com.grupo01.jobby.DTO.profissao.ProfissaoResquestDTO;
import com.grupo01.jobby.model.cadastro.enums.SexoEnum;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;
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

    @Column(columnDefinition = "DATE")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private SexoEnum sexoEnum;

    @Embedded
    private PretensaoSalarial pretensaoSalarial;

    @Embedded

    private Celular celularPessoal;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="numero",
                    column=@Column(name="cel_num_prof")),
            @AttributeOverride(name="whatsapp",
                    column=@Column(name="cel_is_whats_prof"))
    })
    private Celular celularProfissional;

    @Embedded
    private Endereco endereco;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_profissao")
    private Profissao Profissao;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "candidato_experiencia")
    private List<CadastroExperiencia> experiencias;

    @ManyToMany
    @JoinTable(name = "candidato_habilidade")
    private List<Habilidade> habilidades;

}
