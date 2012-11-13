package com.gugawag.projeto.modelo;

import java.io.Serializable;

public class Item implements Serializable{
	private int quantidade;
	private Produto produto;
	
	public Item(){
		produto = new Produto();
	}
	
	public Item(Produto produto) {
		super();
		quantidade = 1;
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public double getValorTotal(){
		return quantidade * produto.getValor();
	}

}
