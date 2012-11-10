package com.gugawag.projeto.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gugawag.projeto.modelo.Carrinho;

@Stateless
public class CarrinhoRepositorio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="projeto-PU")
	private EntityManager em;
	
	public void cadastrarCarrinho(Carrinho carrinho){
		em.persist(carrinho);
	}
	
	public List<Carrinho> getCarrinho(){
		return em.createQuery("from Carrinho").getResultList();
	}
	
}
