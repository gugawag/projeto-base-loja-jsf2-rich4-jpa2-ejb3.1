package com.gugawag.projeto.beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import com.gugawag.projeto.modelo.Usuario;
import com.gugawag.projeto.repositorio.PedidoRepositorio;
import com.gugawag.projeto.repositorio.UsuarioRepositorio;
import com.gugawag.projeto.service.UsuarioService;
import com.gugawag.projeto.service.UsuarioJahCadatradoException;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{
	
	private Usuario usuario, usuarioLogado;
	private String senhaRedigitada;
	private String textoSenhas;
	private String styleMensagemSenha; 
	
	@EJB
	private UsuarioService usuarioService;
	
	@EJB
	private UsuarioRepositorio usuarioRep;

	public UsuarioBean(){
		usuario = new Usuario();
		senhaRedigitada = "";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public List<Usuario> getUsuarios(){
		return usuarioService.getUsuarios();
	}
	
	public String getSenhaRedigitada() {
		return senhaRedigitada;
	}

	public void setSenhaRedigitada(String senhaRedigitada) {
		this.senhaRedigitada = senhaRedigitada;
	}
	
	public String getTextoSenhas() {
		return textoSenhas;
	}

	public void setTextoSenhas(String textoSenhas) {
		this.textoSenhas = textoSenhas;
	}

	public String getStyleMensagemSenha() {
		return styleMensagemSenha;
	}

	public void setStyleMensagemSenha(String styleMensagemSenha) {
		this.styleMensagemSenha = styleMensagemSenha;
	}

	public String editar(Usuario usuario){
		this.usuario = usuario;
		return "editarUsuario";
	}
	
	public void atualizar(ActionEvent event){
		usuarioService.atualizar(usuario);
		FacesMessage message = new FacesMessage("Usuário atualizado com sucesso!");
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, message);		
	}
	
	
	public String cadastrar(){
		try {
			usuarioService.cadastrarUsuario(usuario);
		} catch (UsuarioJahCadatradoException e) {
			FacesMessage message = new FacesMessage("Usuário já cadastrado!");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}
		FacesMessage message = new FacesMessage("Usuário cadastrado com sucesso!");
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, message);
		//fazendo esse usuário apontar para um novo
		usuario = new Usuario();
		return null;
	}
	
	public String remover(Usuario usuario){
		usuarioService.remover(usuario);
		return null;
	}
	
	public void checarSenhas() {
		if (usuario.getSenha().equals(senhaRedigitada)) {
			textoSenhas = "Senhas conferem!";
			styleMensagemSenha = "color:blue";
		} else {
			textoSenhas = "Senhas n‹ão conferem!";
			styleMensagemSenha = "color:red";
		}
	}
	
	public String logar(){
		Usuario usuarioPesquisado = usuarioService.getUsuarioPorLogin(usuario.getLogin());
		System.out.println("USUARIO: " + usuarioPesquisado);
		if (usuarioPesquisado == null || !usuario.getSenha().equals(usuarioPesquisado.getSenha())){
			FacesMessage message = new FacesMessage("Usuário inexistente e/ou senha inválida!");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}
		this.usuarioLogado = usuarioPesquisado;
		return "listagemProdutosParaUsuarios";
	}


}
