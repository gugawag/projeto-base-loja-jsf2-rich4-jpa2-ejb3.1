package com.gugawag.projeto.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Carrinho implements Serializable{
	
	@Id @GeneratedValue
	private Integer codigo;
	
	@Transient
	private List<ItemCarrinho> itens;
	
	public Carrinho() {
		itens = new ArrayList<ItemCarrinho>();
	}

	public List<ItemCarrinho> getItens() {
		return itens;
	}

	public void setItens(List<ItemCarrinho> itens) {
		this.itens = itens;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void insereItem(ItemCarrinho item){
		boolean achou = false;
		for (ItemCarrinho it: itens){
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
		for(ItemCarrinho item: itens){
			soma+=item.getValorTotal();
		}
		return soma;
	}
	

}
