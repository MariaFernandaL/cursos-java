package co.edu.cue.empresaalimentos.controller;

import co.edu.cue.empresaalimentos.model.EmpresaAlimento;
import co.edu.cue.empresaalimentos.model.Producto;
import co.edu.cue.empresaalimentos.model.Proveedor;
import co.edu.cue.empresaalimentos.service.IModelFactoryController;

public class ModelFactoryController implements IModelFactoryController{

	EmpresaAlimento empresaAlimento;
	
	
	//------------------------------  Singleton ------------------------------------------------
		// Clase estatica oculta. Tan solo se instanciara el singleton una vez
		private static class SingletonHolder { 
			// El constructor de Singleton puede ser llamado desde aquí al ser protected
			private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
		}

		// Método para obtener la instancia de nuestra clase
		public static ModelFactoryController getInstance() {
			return SingletonHolder.eINSTANCE;
		}
		
		public ModelFactoryController() {
			inicializarDatos();
		}

		
		private void inicializarDatos() {
			empresaAlimento= new EmpresaAlimento();
			Proveedor proveedor= new Proveedor();
			empresaAlimento.getListaProveedores().add(proveedor);
			
		}

		@Override
		public Producto crearProducto(String nombre, String codigo, double precioCompra, String descripcion) {
			
			return empresaAlimento.agregarProducto(nombre, codigo, precioCompra, descripcion);
		}

		
}
