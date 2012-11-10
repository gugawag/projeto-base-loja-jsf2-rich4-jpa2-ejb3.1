package com.gugawag.projeto.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_PRODUTO")
public class Produto {
	
	@Id @GeneratedValue
	private int codigo;
	private String descricao;
	private Double valor;
	
	public Produto(String descricao, Double valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public Produto() {
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	
}
