package com.gugawag.projeto.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Carrinho implements Serializable{
	
	private List<Item> itens;
	
	public Carrinho() {
		itens = new ArrayList<Item>();
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public void insereItem(Item item){
		boolean achou = false;
		for (Item it: itens){
			if (it.getProduto().getCodigo()==item.getProduto().getCodigo()){
				it.setQuantidade(it.getQuantidade()+1);
				achou = true;
				return;
			}
		}
		if (!achou){
			this.itens.add(item);
		}
	}
	
	public double getValorTotal(){
		double soma=0;
		for(Item item: itens){
			soma+=item.getValorTotal();
		}
		return soma;
	}

	public void removerProduto(Produto produto) {
		for (Item item: this.getItens()){
			if (item.getProduto().getCodigo() == produto.getCodigo()){
				this.getItens().remove(item);
				break;
			}
		}
	}
	

}
