package com.gugawag.projeto.listeners;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.gugawag.projeto.modelo.Produto;

/**
 * Application Lifecycle Listener implementation class AplicacaoListener
 *
 */
@WebListener
public class AplicacaoListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AplicacaoListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
    		List<Produto> produtos = new ArrayList<Produto>();
    		produtos.add(new Produto("Sapato", 12.1));
    		produtos.add(new Produto("PC", 1.0));
    		produtos.add(new Produto("Relógio", 120.6));
    		event.getServletContext().setAttribute("produtos", produtos);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    		System.out.println("Destruiu");
    }
	
}
