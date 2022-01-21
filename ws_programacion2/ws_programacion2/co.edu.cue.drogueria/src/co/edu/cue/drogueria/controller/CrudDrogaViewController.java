package co.edu.cue.drogueria.controller;

import co.edu.cue.drogueria.model.Drogueria;

public class CrudDrogaViewController {

	ModelFactoryController modelFactory;
	Drogueria drogueria;
	
	public CrudDrogaViewController(ModelFactoryController modelFactory) {
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
