package com.cilene.pessoas.business.pessoas.persistence.entity;

import com.cilene.pessoas.business.pessoas.persistence.entity.EnderecoEntity;
import com.cilene.pessoas.business.pessoas.persistence.entity.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pessoas")
public class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String documento;
    private Integer idade;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "pessoa")
    private EnderecoEntity endereco;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "pessoa")
    private ContatoEntity contato;
}
