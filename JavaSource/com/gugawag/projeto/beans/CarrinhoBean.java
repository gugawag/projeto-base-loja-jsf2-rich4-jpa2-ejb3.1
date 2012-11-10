package com.gugawag.projeto.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.gugawag.projeto.modelo.Carrinho;
import com.gugawag.projeto.modelo.ItemCarrinho;
import com.gugawag.projeto.modelo.Produto;
import com.gugawag.projeto.service.CarrinhoService;

@ManagedBean
@SessionScoped
public class CarrinhoBean {
	
	@EJB
	private CarrinhoService carrinhoService;
	
	public String comprar(Produto produto){
		carrinhoService.inserirProduto(produto);
		return null;
	}

}
