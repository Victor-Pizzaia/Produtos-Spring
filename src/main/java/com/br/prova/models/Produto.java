package com.br.prova.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduto;
	private String nome;
	private String descricao;
	private double valor;
	private long quantidadeEstoque;
}
