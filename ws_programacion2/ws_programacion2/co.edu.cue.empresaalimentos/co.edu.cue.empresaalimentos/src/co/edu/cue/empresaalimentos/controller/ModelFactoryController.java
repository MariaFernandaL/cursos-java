package co.edu.cue.empresaalimentos.controller;

import java.util.ArrayList;

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
			
			Producto producto= new Producto();
			producto.setNombre("arroz");
			producto.setCodigo("54637");
			producto.setPrecioCompra("3.000");
			producto.setDescripcion("producto basico para el hogar");
			empresaAlimento.getListaProductos().add(producto);
			
			producto= new Producto();
			producto.setNombre("aceite");
			producto.setCodigo("12349");
			producto.setPrecioCompra("10.000");
			producto.setDescripcion("producto basico para el hogar");
			empresaAlimento.getListaProductos().add(producto);
			
			producto= new Producto();
			producto.setNombre("panela");
			producto.setCodigo("65438");
			producto.setPrecioCompra("3.000");
			producto.setDescripcion("producto basico para el hogar");
			empresaAlimento.getListaProductos().add(producto);
		}

		
		@Override
		public Producto crearProducto(String nombre, String codigo, String precioCompra, String descripcion) {
			
			return empresaAlimento.agregarProducto(nombre, codigo, precioCompra, descripcion);
		}

		@Override
		public Boolean eliminarProducto(String codigo) {

			return empresaAlimento.eliminarProducto(codigo);
		}

		@Override
		public Boolean actualizarProducto(String codigoActual, String nombre, String codigo, String precio,
				String descripcion) {
			return empresaAlimento.actualizarProducto(codigoActual, nombre, codigo, precio, descripcion);
		}

		@Override
		public Producto obtenerProducto(String codigo) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public ArrayList<Producto> obtenerProductos() {
			
			return empresaAlimento.getListaProductos();
		}

		
}
