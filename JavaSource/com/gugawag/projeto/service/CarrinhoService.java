package com.gugawag.projeto.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import com.gugawag.projeto.modelo.Carrinho;
import com.gugawag.projeto.modelo.Item;
import com.gugawag.projeto.modelo.Produto;
import com.gugawag.projeto.repositorio.PedidoRepositorio;

@Stateful
public class CarrinhoService {

	private Carrinho carrinho;
	
	@EJB
	private PedidoRepositorio pedidoRepositorio;
		
	public CarrinhoService(){
		carrinho = new Carrinho();
	}

	public void salvarCarrinho(){
		pedidoRepositorio.salvarPedido(carrinho);
	}
	
	public void inserirProduto(Produto produto) {
		carrinho.insereItem(new Item(produto));		
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public void removerProduto(Produto produtoARemover) {
		carrinho.removerProduto(produtoARemover);
	}
	
}
