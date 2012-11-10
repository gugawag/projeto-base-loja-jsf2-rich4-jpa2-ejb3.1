package com.gugawag.projeto.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="TB_USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Integer codigo;
	
	private String login;
	private String cpf;
	private String email;
	private String senha;
	

	//A FAZER - Alterar cadastro de usu�rio para ter o endere�o e a data de nascimento
	@Transient
	private Endereco endereco;
	private Date dataNascimento;
	
	@Transient
	private List<Carrinho> carrinhos;
	
	public Usuario(){
		this(null, null, null);
	}
	
	public Usuario(String login, String cpf, String email) {
		super();
		this.login = login;
		this.cpf = cpf;
		this.email = email;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", login=" + login + ", cpf="
				+ cpf + "]";
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Carrinho> getCarrinhos() {
		return carrinhos;
	}

	public void setCarrinhos(List<Carrinho> carrinhos) {
		this.carrinhos = carrinhos;
	}
	
}
