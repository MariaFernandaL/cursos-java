package co.edu.cue.drogueria.controller;

import co.edu.cue.drogueria.model.Drogueria;

public class CrudClienteViewController {

	ModelFactoryController modelFactory;
	Drogueria drogueria;
	
	public CrudClienteViewController(ModelFactoryController modelFactory) {
		this.modelFactory = modelFactory;
		drogueria= modelFactory.getDrogueria();
	}

	public Drogueria getDrogueria() {
		return drogueria;
	}

	public void setDrogueria(Drogueria drogueria) {
		this.drogueria = drogueria;
	}
}
