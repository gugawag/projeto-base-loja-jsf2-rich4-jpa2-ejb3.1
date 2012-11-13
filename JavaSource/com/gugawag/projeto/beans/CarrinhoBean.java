package com.gugawag.projeto.beans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.gugawag.projeto.modelo.Carrinho;
import com.gugawag.projeto.modelo.Item;
import com.gugawag.projeto.modelo.Produto;
import com.gugawag.projeto.service.CarrinhoService;

@ManagedBean
@SessionScoped
public class CarrinhoBean {
	
	@EJB
	private CarrinhoService carrinhoService;
	
	public String comprar(Produto produto){
		carrinhoService.inserirProduto(produto);
		return "carrinho";
	}
	
	public String removerItem(Item item){
		carrinhoService.removerProduto(item.getProduto());
		FacesMessage message = new FacesMessage("Produto removido com sucesso!");
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, message);
		return null;
	}
	
	public Carrinho getCarrinho(){
		return carrinhoService.getCarrinho();
	}
	
	public String fecharCompra(){
		carrinhoService.salvarCarrinho();
		return "compraFinalizada";
	}

}
