package com.cilene.pessoas.business.pessoas.persistence.entity;

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
@Table(name = "enderecos")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoLogradouro;
    private String logradouro;
    private String cidade;
    private String numero;
    private String cep;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pessoa", nullable = false)
    private PessoaEntity pessoa;

}
