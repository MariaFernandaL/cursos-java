package co.edu.cue.banco.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.cue.banco.application.Aplicacion;
import co.edu.cue.banco.model.Cliente;
import co.edu.cue.banco.model.Empleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class BancoViewController {

	Aplicacion aplicacion;
	ModelFactoryController modelFactoryController;
	CrudClienteViewController crudClienteViewController;
	CrudEmpleadoViewController crudEmpleadoViewController;
	
	ObservableList<Empleado> listaEmpleadosData = FXCollections.observableArrayList();
	Empleado empleadoSeleccionado;
	
	ObservableList<Cliente> listaClientesData   = FXCollections.observableArrayList();
	
	
	
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombreEmpleado;

    @FXML
    private Button btnNuevoEmpleado;

    @FXML
    private TableColumn<Empleado, String> clNombreEmpleado;

    @FXML
    private TableColumn<Empleado, String> clApellidoEmpleado;

    @FXML
    private Button btnAgregarEmpleado;

    @FXML
    private TextField txtApellidoEmpleado;

    @FXML
    private TextField txtCedulaEmpleado;

    @FXML
    private TableColumn<Empleado, String> clFechaNacimientoEmpleado;

    @FXML
    private Button btnActualizarEmpleado;

    @FXML
    private Button btnEliminarEmpleado;

    @FXML
    private TextField txtFechaNacimientoEmpleado;

    @FXML
    private TableView<Empleado> tableEmpleados;

    @FXML
    private TableColumn<Empleado, String> clCedulaEmpleado;



    @FXML
    void initialize() {
    	modelFactoryController = ModelFactoryController.getInstance();
    	crudClienteViewController = new CrudClienteViewController(modelFactoryController);
    	crudEmpleadoViewController = new CrudEmpleadoViewController(modelFactoryController);
    	
    	inicializarEmpleadoView();
    	inicializarClienteView();
    }
    


	private void inicializarEmpleadoView() {
		
		this.clNombreEmpleado.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.clApellidoEmpleado.setCellValueFactory(new PropertyValueFactory<>("apellido"));
		this.clCedulaEmpleado.setCellValueFactory(new PropertyValueFactory<>("cedula"));
		this.clFechaNacimientoEmpleado.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
		
		
		tableEmpleados.getItems().clear();
		tableEmpleados.setItems(getListaEmpleadosData());
		
		tableEmpleados.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			empleadoSeleccionado = newSelection;

			mostrarInformacionEmpleado(empleadoSeleccionado);

		});
		
	}
	
	
	private void mostrarInformacionEmpleado(Empleado empleadoSeleccionado) {
		
		
		if(empleadoSeleccionado != null){
			txtNombreEmpleado.setText(empleadoSeleccionado.getNombre());
			txtApellidoEmpleado.setText(empleadoSeleccionado.getApellido());
			txtCedulaEmpleado.setText(empleadoSeleccionado.getCedula());
			txtFechaNacimientoEmpleado.setText(empleadoSeleccionado.getFechaNacimiento());
			
		}
		
	}



	private void inicializarClienteView() {
		// TODO Auto-generated method stub
		
	}
    
    
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
	
	public ObservableList<Empleado> getListaEmpleadosData() {
		listaEmpleadosData.addAll(crudEmpleadoViewController.obtenerEmpleados());
		return listaEmpleadosData;
	}
	
	
	




	@FXML
    void nuevoEmpleadoAction(ActionEvent event) {
    	txtNombreEmpleado.setText("Ingrese el nombre");
    	txtApellidoEmpleado.setText("Ingrese el apellido");
    	txtCedulaEmpleado.setText("Ingrese la cédula");
    	txtFechaNacimientoEmpleado.setText("Ingrese la fecha de nacimiento");
    }

    @FXML
    void agregarEmpleadoAction(ActionEvent event) {
    	
    	crearEmpleado();
    }

    private void crearEmpleado() {
		
    	//1. Capturar los datos
    	String nombre = txtNombreEmpleado.getText();
    	String apellido = txtApellidoEmpleado.getText();
    	String cedula = txtCedulaEmpleado.getText();
    	String fechaNacimiento = txtFechaNacimientoEmpleado.getText();
    	
    	//2. Validar la información
    	if(datosValidos(nombre, apellido, cedula, fechaNacimiento)== true){
    		
    		Empleado empleado = null;
    		
    		empleado = crudEmpleadoViewController.crearEmpleado(nombre,apellido,cedula,fechaNacimiento);
    		
    		if(empleado != null){
    			listaEmpleadosData.add(empleado);
    			mostrarMensaje("Notificación empleado", "Empleado creado", "El empleado se ha creado con éxito", AlertType.INFORMATION);
    			limpiarCamposEmpleado();
    		}else{
    			mostrarMensaje("Notificación empleado", "Empleado no creado", "El empleado no se ha creado con éxito", AlertType.INFORMATION);
    		}
    	}else{
    		mostrarMensaje("Notificación empleado", "Empleado no creado", "Los datos ingresados son invalidos", AlertType.ERROR);
    	}
		
	}


	@FXML
    void eliminarEmpleadoAction(ActionEvent event) {
		
		eliminarEmpleado();
    }
	
	
	private void eliminarEmpleado() {
		
		boolean empleadoEliminado = false;
		
		
		if(empleadoSeleccionado != null){
			
			
			if(mostrarMensajeConfirmacion("¿Estas seguro de elmininar al empleado?") == true){
				
				empleadoEliminado = crudEmpleadoViewController.eliminarEmpleado(empleadoSeleccionado.getCedula());
				
				
				if(empleadoEliminado == true){
					listaEmpleadosData.remove(empleadoSeleccionado);
					empleadoSeleccionado = null;
					
					tableEmpleados.getSelectionModel().clearSelection();
					limpiarCamposEmpleado();
					mostrarMensaje("Notificación empleado", "Empleado eliminado", "El empleado se ha eliminado con éxito", AlertType.INFORMATION);
				}else{
					mostrarMensaje("Notificación empleado", "Empleado no eliminado", "El empleado no se puede eliminar", AlertType.ERROR);
				}
			}
		}else{
			mostrarMensaje("Notificación empleado", "Empleado no seleccionado", "Seleccionado un empleado de la lista", AlertType.WARNING);
		}
	}


	
    @FXML
    void actualizarEmpleadoAction(ActionEvent event) {
    	actualizarEmpleado();
    }

    private void actualizarEmpleado() {
		
    	
       	//1. Capturar los datos
    	String nombre = txtNombreEmpleado.getText();
    	String apellido = txtApellidoEmpleado.getText();
    	String cedula = txtCedulaEmpleado.getText();
    	String fechaNacimiento = txtFechaNacimientoEmpleado.getText();
    	boolean clienteActualizado = false;
    	
    	
    	//2. verificar el empleado seleccionado
    	if(empleadoSeleccionado != null){
        	
    		//3. Validar la información
        	if(datosValidos(nombre, apellido, cedula, fechaNacimiento)== true){
        		
        		
        		clienteActualizado = crudEmpleadoViewController.actualizarEmpleado(empleadoSeleccionado.getCedula(),nombre,apellido,cedula,fechaNacimiento);
        		
        		
        		if(clienteActualizado == true){
        			tableEmpleados.refresh();
        			mostrarMensaje("Notificación empleado", "Empleado actualizado", "El empleado se ha actualizado con éxito", AlertType.INFORMATION);
        			limpiarCamposEmpleado();
        		}else{
        			mostrarMensaje("Notificación empleado", "Empleado no actualizado", "El empleado no se ha actualizado con éxito", AlertType.INFORMATION);
        		}
        	}else{
        		mostrarMensaje("Notificación empleado", "Empleado no creado", "Los datos ingresados son invalidos", AlertType.ERROR);
        	}
        	
    	}		
	}
	
	
	
	private void limpiarCamposEmpleado() {
    	txtNombreEmpleado.setText("");
    	txtApellidoEmpleado.setText("");
    	txtCedulaEmpleado.setText("");
    	txtFechaNacimientoEmpleado.setText("");
	}

	private void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

		Alert aler = new Alert(alertType);
		aler.setTitle(titulo);
		aler.setHeaderText(header);
		aler.setContentText(contenido);
		aler.showAndWait();
	}

	private boolean mostrarMensajeConfirmacion(String mensaje) {

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Confirmación");
		alert.setContentText(mensaje);
		Optional<ButtonType> action = alert.showAndWait();

		if (action.get() == ButtonType.OK) {
			return true;
		} else {
			return false;
		}
	}
	
	
	private boolean datosValidos(String nombre, String apellido, String cedula,  String fechaNacimiento) {

		String mensaje = "";


		if(nombre == null || nombre.equals(""))
			mensaje += "El nombre es invalido \n" ;

		if(apellido == null || apellido.equals(""))
			mensaje += "El apellido es invalido \n" ;

		if(cedula == null || cedula.equals(""))
			mensaje += "El documento es invalido \n" ;

		if(fechaNacimiento == null || fechaNacimiento.equals(""))
			mensaje += "La direccion es invalida \n" ;



		if(mensaje.equals("")){
			return true;
		}else{
			mostrarMensaje("Notificación cliente","Datos invalidos",mensaje, AlertType.WARNING);
			return false;
		}
	}
    
}
