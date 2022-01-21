package co.edu.cue.empresaalimentos.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

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

	
	
	ModelFactoryController modelFactory = ModelFactoryController.getInstance();
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textCodigo;

    @FXML
    private TableView<?> tableProducto;

    @FXML
    private TableColumn<?, ?> colCodigo;

    @FXML
    private TableColumn<?, ?> colDescripcion;

    @FXML
    private Button btnAgregarProducto;

    @FXML
    private TextField textNombre;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TextField textDescripcion;

    @FXML
    void agregarProductoAction(ActionEvent event) {
    	
    	agregarProducto();
    }

    private void agregarProducto() {
	
    	
    	//1. Capturar los datos de los campos de texto
    	String codigo = textCodigo.getText();
    	String nombre = textNombre.getText();
    	String descripcion = textDescripcion.getText();

    	//2. Validar la información
    	if(datosValidos(codigo, nombre, descripcion) == true){

    		//3. Registrar el producto
    		Producto producto = null;

    		producto = modelFactory.crearProducto(codigo, nombre, descripcion);

    		if(producto != null){
//    			listaClientesData.add(producto);
//    			limpiarCamposTexto();
    			mostrarMensaje("Notificación producto", "producto registrado", "El producto se ha registrado con éxtio", AlertType.INFORMATION);
    		}else{
    			mostrarMensaje("Notificación producto", "producto no registrado", "El producto con codigo "+codigo+" ya se encuentra registrado", AlertType.ERROR);
    		}
    	}
		
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

	
	private boolean datosValidos(String codigo, String nombre, String descripcion) {

		String mensaje = "";

		if(codigo == null || codigo.equals(""))
			mensaje += "El nombre es invalido \n";

		if(nombre == null || nombre.equals(""))
			mensaje += "El apellido es invalido \n";

		if(descripcion == null || descripcion.equals(""))
			mensaje += "El documento es invalido \n";


		if(mensaje.equals("")){
			return true;
		}else{
			mostrarMensaje("Información producto", "Datos invalidos", mensaje, AlertType.WARNING);
			return false;
		}
	}

	
}
