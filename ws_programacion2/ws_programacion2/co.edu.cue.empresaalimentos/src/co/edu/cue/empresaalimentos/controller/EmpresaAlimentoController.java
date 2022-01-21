package co.edu.cue.empresaalimentos.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.cue.empresaalimentos.model.EmpresaAlimento;
import co.edu.cue.empresaalimentos.model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmpresaAlimentoController {
	
	
	ModelFactoryController modelFactory= ModelFactoryController.getInstance();
	
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextField txtNombre;

	    @FXML
	    private TableView<Producto> tableProducto;

	    @FXML
	    private TableColumn<Producto, String> colCodigo;

	    @FXML
	    private TableColumn<Producto, String> colDescripcion;

	    @FXML
	    private Button btnEliminar;
	    
	    @FXML
	    private Button btnNuevo;

	    @FXML
	    private TableColumn<Producto, String> colNombre;

	    @FXML
	    private TextField txtCodigo;

	    @FXML
	    private Button btnAgregar;

	    @FXML
	    private TextField txtDescripcion;

	    @FXML
	    private TextField txtPrecio;

	    @FXML
	    private Button btnActualizar;

	    EmpresaAlimento empresaA;
	    
	    ObservableList<Producto> listaProductosData= FXCollections.observableArrayList();
	   
	    Producto productoSeleccionado;
	    
	    public void setEmpresaA(EmpresaAlimento empresaA) {
			this.empresaA = empresaA;
		}	    

	    @FXML
	    void initialize() {
	    	this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
	    	this.colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
	    	this.colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

	    	
	    	tableProducto.getItems().clear();
			tableProducto.setItems(getListaProductosData());
			
	    	tableProducto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

	    		productoSeleccionado = newSelection;
	    		mostrarInformacionProductos(productoSeleccionado);
	    	});
	    }
	    
	    public ObservableList<Producto> getListaProductosData() {
			listaProductosData.addAll(modelFactory.obtenerProductos());
			return listaProductosData;
		}
	    
	    
	    
	    
	    @FXML
	    void agregarProductoAction(ActionEvent event) {

	    	agregarProducto();
	    }

	    private void agregarProducto() {
	    	

	        	//1. Capturar los datos de los campos de texto
	        	String nombre = txtNombre.getText();
	        	String codigo = txtCodigo.getText();
	        	String descripcion = txtDescripcion.getText();
	        	String precio = txtPrecio.getText();

	        	//2. Validar la información
	        	if(datosValidos(nombre, codigo, descripcion, precio) == true){

	        		//3. Registrar el cliente
	        		Producto producto = null;

	        		producto = modelFactory.crearProducto(nombre, codigo, precio, descripcion);

	        		if(producto != null){
	        			listaProductosData.add(producto);
	        			limpiarCamposTexto();
	        			mostrarMensaje("Notificación producto", "producto registrado", "El producto se ha registrado con éxito", AlertType.INFORMATION);
	        		}else{
	        			mostrarMensaje("Notificación producto", "producto no registrado", "El producto ya se encuentra registrado", AlertType.ERROR);
	        		}
	        	}

			
		}

		@FXML
	    void actualizarProductoAction(ActionEvent event) {

			actualizarProducto();
	    }

	    private void actualizarProducto() {
	    	//1. Capturar los datos de los campos de texto
	    	    	String nombre = txtNombre.getText();
	    	    	String codigo = txtCodigo.getText();
	    	    	String descripcion = txtDescripcion.getText();
	    	    	String precio = txtPrecio.getText();

	    	    	boolean productoActualizado = false;

	    	    	if(productoSeleccionado != null){
	    	        	//2. Validar la información
	    	        	if(datosValidos(nombre, codigo, descripcion, precio) == true){


	    	        		productoActualizado = modelFactory.actualizarProducto(productoSeleccionado.getCodigo(), nombre, codigo, precio, descripcion);

	    	        		if(productoActualizado == true){
	    	        			tableProducto.refresh();
	    	        			mostrarMensaje("Notificación producto", "producto actualizado", "El producto se ha actualizado con éxtio", AlertType.INFORMATION);
	    	        		}else{
	    	        			mostrarMensaje("Notificación producto", "producto no actualizado", "El producto no se puede actualizar", AlertType.ERROR);
	    	        		}
	    	        	}
	    	    	}else{
	    	    		mostrarMensaje("Notificación producto", "producto no seleccionado", "Debe seleccionar un producto", AlertType.WARNING);
	    	    	}
	    		}


		@FXML
	    void eliminarProductoAction(ActionEvent event) {

	    	eliminarProducto();
	    }

	    
	    private void eliminarProducto() {

	    	boolean productoEliminado = false;

	    	if( productoSeleccionado!= null){


	    		if(mostrarMensajeConfirmacion("¿Esta seguro de eliminar al cliente?") == true){

	    			productoEliminado = modelFactory.eliminarProducto(productoSeleccionado.getCodigo());

	        		if(productoEliminado == true){

	        			listaProductosData.remove(productoSeleccionado);
	        			productoSeleccionado = null;
	        			tableProducto.getSelectionModel().clearSelection();
	        			limpiarCamposTexto();
	        			mostrarMensaje("Notificación productos", "producto eliminado", "producto eliminado con éxito", AlertType.INFORMATION);
	        		}else{
	        			mostrarMensaje("Notificación productos", "producto no eliminado", "El producto no se logro eliminar", AlertType.ERROR);
	        		}
	    		}

	    	}else{
	    		mostrarMensaje("Notificación productos", "productos no seleccionado", "Debe seleccionar un producto", AlertType.WARNING);
	    	}

		}
	    @FXML
	    void nuevoProductoAction(ActionEvent event) {

	    	nuevoProducto();
	    }
	    private void nuevoProducto() {
	    	txtNombre.setText("Ingrese el nombre");
			txtCodigo.setText("Ingrese el codigo");
			txtDescripcion.setText("Ingrese la descripcion");
			txtPrecio.setText("Ingrese el precio");
		}

	    private void limpiarCamposTexto() {
	    	txtNombre.setText("");
			txtCodigo.setText("");
			txtDescripcion.setText("");
			txtPrecio.setText("");
		}

	
	    public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

	    	Alert alert = new Alert(alertType);
	    	alert.setTitle(titulo);
	    	alert.setHeaderText(header);
	    	alert.setContentText(contenido);
	    	alert.showAndWait();
		}

	    private boolean mostrarMensajeConfirmacion(String mensaje) {

		   	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	    	alert.setTitle("Confirmación");
	    	alert.setHeaderText(null);
	    	alert.setContentText(mensaje);

	    	Optional<ButtonType> action = alert.showAndWait();

	    	if(action.get() == ButtonType.OK){
	    		return true;
	    	}else{
	    		return false;
	    	}
		}

		private boolean datosValidos(String nombre, String codigo, String descripcion, String precio) {

			String mensaje = "";

			if(nombre == null || nombre.equals(""))
				mensaje += "El nombre es invalido \n";

			if(codigo == null || codigo.equals(""))
				mensaje += "El codigo es invalido \n";

			if(descripcion == null || descripcion.equals(""))
				mensaje += "La descripcion es invalida \n";

			if(precio == null || precio.equals(""))
				mensaje += "El precio es invalido \n";

			if(mensaje.equals("")){
				return true;
			}else{
				mostrarMensaje("Información producto", "Datos invalidos", mensaje, AlertType.WARNING);
				return false;
			}
		}

		private void mostrarInformacionProductos(Producto productoSeleccionado) {
			if(productoSeleccionado != null){
				txtNombre.setText(productoSeleccionado.getNombre());
				txtCodigo.setText(productoSeleccionado.getCodigo());
				txtDescripcion.setText(productoSeleccionado.getDescripcion());
				txtPrecio.setText(productoSeleccionado.getPrecioCompra());
			}
		}

		
}