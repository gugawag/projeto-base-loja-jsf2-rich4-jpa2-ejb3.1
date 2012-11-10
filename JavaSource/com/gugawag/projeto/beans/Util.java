package com.gugawag.projeto.beans;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Util {

	public static void acrescentaMensagem(String chaveMensagem, String[] parametros) {
		FacesContext fc = FacesContext.getCurrentInstance();
		ResourceBundle bundle = fc.getApplication().getResourceBundle(fc, "msg");
		fc.addMessage(null, new FacesMessage(bundle.getString(chaveMensagem)));
	}

}
