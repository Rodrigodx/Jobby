package com.grupo01.jobby.model.cadastro;

import com.grupo01.jobby.DTO.cadastro.CadastroResquestDTO;
import com.grupo01.jobby.DTO.profissao.ProfissaoResquestDTO;
import com.grupo01.jobby.model.cadastro.enums.SexoEnum;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

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

    /*@OneToOne
    @JoinColumn(name = "id_profissao")*/
    private Integer id_Profissao;

    @Column(name = "habil")
    private List<String> habilidades;

    public void atualizar(CadastroResquestDTO dadosCadastro) {
        BeanUtils.copyProperties(this, dadosCadastro);
    }

}
