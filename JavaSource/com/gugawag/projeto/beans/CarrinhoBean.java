package com.gugawag.projeto.beans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
	
	@ManagedProperty("#{usuarioBean}")
	private UsuarioBean usuarioBean;
	
	public String comprar(Produto produto){
		if (carrinhoService.getDonoCarrinho() == null){
			carrinhoService.setDonoCarrinho(usuarioBean.getUsuarioLogado());	
		}
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
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "compraFinalizada";
	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}
