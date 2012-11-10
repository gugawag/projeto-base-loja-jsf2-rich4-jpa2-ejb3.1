package com.gugawag.projeto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco {
	
	@Id @GeneratedValue
	private int codigo;
	private String logradouro;
	@Column(length=10, nullable=false)
	private String cep;
	
	@Enumerated(EnumType.STRING)
	private Uf uf;
	
	public Endereco(String logradouro, String cep) {
		super();
		this.logradouro = logradouro;
		this.cep = cep;
	}
	public Endereco() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}

	
}
