package com.cilene.pessoas.business.pessoas.service;

import com.cilene.pessoas.business.pessoas.persistence.entity.PessoaEntity;
import com.cilene.pessoas.business.pessoas.persistence.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public PessoaEntity save(PessoaEntity entity){
        return repository.save(entity);
    }

    public PessoaEntity atualiza(PessoaEntity entity, Long id){
        Optional<PessoaEntity> pessoaDaBaseOpcional = repository.findById(id);
        PessoaEntity pessoaDaBase = pessoaDaBaseOpcional.get();
//        pessoaDaBase.setId(entity.getId());
        pessoaDaBase.setNome(entity.getNome());
        pessoaDaBase.setDocumento(entity.getDocumento());
        pessoaDaBase.setSexo(entity.getSexo());
        pessoaDaBase.setIdade(entity.getIdade());
        pessoaDaBase.getContato().setEmail(entity.getContato().getEmail());
        pessoaDaBase.getContato().setTelefone(entity.getContato().getTelefone());
        //pessoaDaBase.getContato().setId(entity.getContato().getId());
        pessoaDaBase.getContato().setPessoa(entity.getContato().getPessoa());
        pessoaDaBase.getEndereco().setPessoa(entity.getEndereco().getPessoa());
        //pessoaDaBase.getEndereco().setId(entity.getEndereco().getId());
        pessoaDaBase.getEndereco().setCep(entity.getEndereco().getCep());
        pessoaDaBase.getEndereco().setCidade(entity.getEndereco().getCidade());
        pessoaDaBase.getEndereco().setLogradouro(entity.getEndereco().getLogradouro());
        pessoaDaBase.getEndereco().setNumero(entity.getEndereco().getNumero());
        pessoaDaBase.getEndereco().setTipoLogradouro(entity.getEndereco().getTipoLogradouro());

        pessoaDaBase.getEndereco().setPessoa(pessoaDaBase);
        pessoaDaBase.getContato().setPessoa(pessoaDaBase);

        return repository.save(pessoaDaBase);
    }

    public void deletar(Long id){
        Optional<PessoaEntity> pessoaDaBaseOpcional = repository.findById(id);
        PessoaEntity pessoaDaBase = pessoaDaBaseOpcional.get();
        repository.delete(pessoaDaBase);
    }

    public List<PessoaEntity> buscarTudos(){
        List<PessoaEntity> pessoas  = repository.findAll();
        return pessoas;
    }



}
