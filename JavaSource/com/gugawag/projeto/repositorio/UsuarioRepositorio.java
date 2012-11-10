package com.gugawag.projeto.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gugawag.projeto.modelo.Usuario;
import com.gugawag.projeto.modelo.UsuarioVO;

@Stateless
public class UsuarioRepositorio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="projeto-PU")
	private EntityManager em;
	
	public void cadastrarUsuario(Usuario usuario){
		em.persist(usuario);
		
		//Mostrando abaixo que com sessão do hibernate aberta (entityManager de JPA), ao alterar um objeto gerenciado
		//será alterado automaticamente no banco de dados (update, delete etc)
//		usuario.setLogin(usuario.getLogin() + " - alterado");
	}
	
	public List<Usuario> getUsuarios(){
		return em.createQuery("from Usuario").getResultList();
	}
	
	public List<UsuarioVO> getUsuariosVO(){
		return em.createQuery("select new UsuarioVO(u.nome) from Usuario u where u.codigo=:codigo").setParameter("codigo", 3).getResultList();
	}
	
	public Usuario getUsuarioPorLogin(String login){
		List<Usuario> usuarios = em.createQuery("from Usuario u where u.login=:login").setParameter("login", login).getResultList();
		if (usuarios != null && usuarios.size()>0){
			return usuarios.get(0);
		}
		return null;
	}
	
	public List<Usuario> getUsuarioPorCPF(String cpf){
		return em.createQuery("from Usuario u where u.cpf like :inicio").setParameter("inicio", cpf+"%").getResultList();
	}
	
	public void remover(Usuario usuario){
		usuario = em.merge(usuario);
		em.remove(usuario);
	}

	public void atualizar(Usuario usuario) {
		em.merge(usuario);
	}

	public Object getTipoUsuarioPorDescricao(String str) {
		return em.createQuery("from TipoUsuario t where t.descricao=:descricao").setParameter("descricao", str).getSingleResult();
	}

}
