package com.cilene.pessoas.business.pessoas.persistence.repository;

import com.cilene.pessoas.business.pessoas.persistence.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {

}
