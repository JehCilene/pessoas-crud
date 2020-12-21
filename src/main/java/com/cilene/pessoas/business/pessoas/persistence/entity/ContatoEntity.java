package com.cilene.pessoas.business.pessoas.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contato")
public class ContatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String telefone;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pessoa", nullable = false)
    private PessoaEntity pessoa;

}
