package com.gugawag.projeto.repositorio;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gugawag.projeto.modelo.Produto;


@Stateless
public class ProdutoRepositorio {
	
	@PersistenceContext
	private EntityManager em;

	public void cadastrar(Produto produto){
		em.persist(produto);
	}
	
	public List<Produto> getProdutos(){
		List<Produto> produtos = em.createQuery("from Produto").getResultList();
		return produtos;
	}
	
	public void remover(Produto produto)
	{
		em.remove(produto);
	}

}
