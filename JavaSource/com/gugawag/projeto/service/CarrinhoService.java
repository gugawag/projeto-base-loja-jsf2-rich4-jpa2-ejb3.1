package com.gugawag.projeto.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.gugawag.projeto.modelo.Carrinho;
import com.gugawag.projeto.modelo.ItemCarrinho;
import com.gugawag.projeto.modelo.Produto;
import com.gugawag.projeto.repositorio.CarrinhoRepositorio;

@Stateless
public class CarrinhoService {

	private Carrinho carrinho;
	@EJB
	private CarrinhoRepositorio carrinhoRepositorio;
		
	public CarrinhoService(){
		carrinho = new Carrinho();
	}

	public void salvarCarrinho(){
		carrinhoRepositorio.cadastrarCarrinho(carrinho);
	}
	
	public void inserirProduto(Produto produto) {
		carrinho.insereItem(new ItemCarrinho(produto));		
	}
}
