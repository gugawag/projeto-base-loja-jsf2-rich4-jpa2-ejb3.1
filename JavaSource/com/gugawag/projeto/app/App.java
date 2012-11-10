package com.gugawag.projeto.app;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.gugawag.projeto.modelo.Usuario;
import com.gugawag.projeto.repositorio.UsuarioRepositorio;

public class App {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		InitialContext context = new InitialContext();
		UsuarioRepositorio uRep = (UsuarioRepositorio) context.lookup("UsuarioRepositorio/remote");
		uRep.cadastrarUsuario(new Usuario("gugawag", "123", "gugawag@gmail"));
		
	}

}
