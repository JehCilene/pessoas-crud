package com.cilene.pessoas.business.pessoas.web.controller;


import com.cilene.pessoas.business.pessoas.persistence.entity.PessoaEntity;
import com.cilene.pessoas.business.pessoas.service.PessoaService;
import com.cilene.pessoas.business.pessoas.web.dto.request.PessoaRequest;
import com.cilene.pessoas.business.pessoas.web.dto.response.PessoaResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;
    private final ModelMapper mapper;

    public PessoaController(PessoaService pessoaService, ModelMapper mapper) {
        this.pessoaService = pessoaService;
        this.mapper = mapper;
    }
    @PostMapping
    public ResponseEntity<PessoaResponse> salvar(@RequestBody PessoaRequest pessoa){

        PessoaEntity pessoaEntity = mapper.map(pessoa, PessoaEntity.class);
        pessoaEntity.getEndereco().setPessoa(pessoaEntity);
        pessoaEntity.getContato().setPessoa(pessoaEntity);
        PessoaEntity inserido = pessoaService.save(pessoaEntity);
        return new ResponseEntity<>(mapper.map(inserido,PessoaResponse.class),HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaResponse> update(@RequestBody PessoaRequest pessoa, @PathVariable  Long id){
        PessoaEntity pessoaEntity = mapper.map(pessoa, PessoaEntity.class);
//        pessoaEntity.getEndereco().setPessoa(pessoaEntity);
//        pessoaEntity.getContato().setPessoa(pessoaEntity);
        PessoaEntity atualizado = pessoaService.atualiza(pessoaEntity, id);
        return new ResponseEntity<>(mapper.map(atualizado,PessoaResponse.class),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PessoaResponse> delete(@PathVariable Long id){
        pessoaService.deletar(id);
        return new ResponseEntity<PessoaResponse>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponse>> buscarTudos(){
        List<PessoaEntity> pessoas = pessoaService.buscarTudos();
        List<PessoaResponse> mapeado = pessoas.stream()
                .map(pessoa -> mapper.map(pessoa, PessoaResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(mapeado, HttpStatus.OK);

    }
}
