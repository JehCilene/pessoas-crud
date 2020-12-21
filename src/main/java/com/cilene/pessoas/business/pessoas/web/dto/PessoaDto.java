package com.cilene.pessoas.business.pessoas.web.dto;

import com.cilene.pessoas.business.pessoas.persistence.entity.enums.Sexo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

@Data
public class PessoaDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    private String nome;
    private String documento;
    private Integer idade;
    private Sexo sexo;
    private EnderecoDto endereco;
    private ContatoDto contato;

}
