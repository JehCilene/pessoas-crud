package com.cilene.pessoas.business.pessoas.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class EnderecoDto {
    @JsonIgnore
    private Long id;

    private String tipoLogradouro;
    private String logradouro;
    private String cidade;
    private String numero;
    private String cep;

}
