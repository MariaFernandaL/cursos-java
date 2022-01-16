package co.edu.cue.empresaalimentos.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.cue.empresaalimentos.model.EmpresaAlimento;
import co.edu.cue.empresaalimentos.model.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EmpresaAlimentoController {
	
	
	ModelFactoryController modelFactory= ModelFactoryController.getInstance();
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextField txtNombre;

	    @FXML
	    private TableView<?> tableProducto;

	    @FXML
	    private TableColumn<?, ?> colCodigo;

	    @FXML
	    private TableColumn<?, ?> colDescripcion;

	    @FXML
	    private Button btnEliminar;

	    @FXML
	    private TableColumn<?, ?> colNombre;

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

	    @FXML
	    void agregarProductoAction(ActionEvent event) {

	    	agregarProducto();
	    }

	    private void agregarProducto() {
	    	

	        	//1. Capturar los datos de los campos de texto
	        	String nombre = txtNombre.getText();
	        	String codigo = txtCodigo.getText();
	        	String descripcion = txtDescripcion.getText();
	        	double  precio = Double.parseDouble(txtPrecio.getText());

	        	//2. Validar la información
	        	if(datosValidos(nombre, codigo, descripcion, precio) == true){

	        		//3. Registrar el cliente
	        		Producto producto = null;

	        		producto = modelFactory.crearProducto(nombre, codigo, precio, descripcion);

	        		if(producto != null){
	        			//listaClientesData.add(cliente);
	        			//limpiarCamposTexto();
	        			mostrarMensaje("Notificación producto", "producto registrado", "El producto se ha registrado con éxito", AlertType.INFORMATION);
	        		}else{
	        			mostrarMensaje("Notificación producto", "producto no registrado", "El producto ya se encuentra registrado", AlertType.ERROR);
	        		}
	        	}

			
		}

		@FXML
	    void actualizarProductoAction(ActionEvent event) {

	    }

	    @FXML
	    void eliminarProductoAction(ActionEvent event) {

	    }

	    @FXML
	    void initialize() {
	        
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

		private boolean datosValidos(String nombre, String codigo, String descripcion, double precioCompra) {

			String mensaje = "";

			if(nombre == null || nombre.equals(""))
				mensaje += "El nombre es invalido \n";

			if(codigo == null || codigo.equals(""))
				mensaje += "El codigo es invalido \n";

			if(descripcion == null || descripcion.equals(""))
				mensaje += "La descripcion es invalida \n";

			if(precioCompra <= 0)
				mensaje += "El precio es invalid \n";

			if(mensaje.equals("")){
				return true;
			}else{
				mostrarMensaje("Información producto", "Datos invalidos", mensaje, AlertType.WARNING);
				return false;
			}
		}

}
