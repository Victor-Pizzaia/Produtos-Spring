package com.br.prova.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.prova.models.Produto;

@Repository
public interface IProdutoRepository extends CrudRepository<Produto, Integer> {}
