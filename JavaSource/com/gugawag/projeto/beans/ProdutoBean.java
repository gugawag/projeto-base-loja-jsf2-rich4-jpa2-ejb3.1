package com.gugawag.projeto.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.gugawag.projeto.modelo.Produto;
import com.gugawag.projeto.repositorio.ProdutoRepositorio;

@ManagedBean
@RequestScoped
public class ProdutoBean {

	@EJB
	private ProdutoRepositorio produtoRep;
	
	private Produto produto;
	
	public ProdutoBean() {
		super();
		produto = new Produto();
	}

	public String cadastrar(){
		produtoRep.cadastrar(produto);
		FacesMessage message = new FacesMessage("Produto cadastrado com sucesso!");
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, message);
		return null;
	}
	
	public List<Produto> getProdutos(){
		return produtoRep.getProdutos();
	}
	
	public String remover(Produto produto)
	{
		produtoRep.remover(produto);
		return null;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
