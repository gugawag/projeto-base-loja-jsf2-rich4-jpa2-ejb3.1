package com.gugawag.projeto.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.gugawag.projeto.modelo.Usuario;
import com.gugawag.projeto.repositorio.UsuarioRepositorio;

@Stateless
public class UsuarioService {
	
	@EJB
	private UsuarioRepositorio usuarioRepositorio;

	public void cadastrarUsuario(Usuario usuario) throws UsuarioJahCadatradoException{
		Usuario usuarioPesquisado = usuarioRepositorio.getUsuarioPorLogin(usuario.getLogin());
		if (usuarioPesquisado != null){
			throw new UsuarioJahCadatradoException("Usu‡ário " + usuario + " j‡á cadastrado!");
		}
		usuarioRepositorio.cadastrarUsuario(new Usuario(usuario.getLogin(), usuario.getCpf(), usuario.getEmail()));
	}

	public List<Usuario> getUsuarios() {
		return usuarioRepositorio.getUsuarios();
	}

	public void remover(Usuario usuario) {
		usuarioRepositorio.remover(usuario);
	}

	public void atualizar(Usuario usuario) {
		usuarioRepositorio.atualizar(usuario);
	}

	public Usuario getUsuarioPorLogin(String login) {
		return usuarioRepositorio.getUsuarioPorLogin(login);
	}

}
