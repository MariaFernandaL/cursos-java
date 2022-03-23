package co.edu.cue.lab.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.cue.lab.model.DetallePrestamo;
import co.edu.cue.lab.model.Elemento;
import co.edu.cue.lab.model.Estudiante;
import co.edu.cue.lab.model.Laboratorio;
import co.edu.cue.lab.model.Monitor;
import co.edu.cue.lab.model.Prestamo;
import co.edu.cue.lab.model.TipoDocumento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class LabController {


Laboratorio laboratorio;	
private Monitor monitorLogin;

	

public Monitor getMonitorLogin() {
	return monitorLogin;
}

public void setMonitorLogin(Monitor monitorLogin) {
	this.monitorLogin = monitorLogin;
}

	ObservableList<Estudiante> listaEstudiantesData = FXCollections.observableArrayList();

	Estudiante estudianteSeleccionado;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableColumn<Estudiante, String> columnDocumento;

	@FXML
	private TextField txtDireccion;

	@FXML
	private Button btnNuevo;

	@FXML
	private TableColumn<Estudiante, String> columnApellido;

	@FXML
	private TableColumn<Estudiante, String> columnNombre;

	@FXML
	private Button btnAgregar;

	@FXML
	private TextField txtDocumento;

	@FXML
	private TableColumn<Estudiante, String> columnDireccion;

	@FXML
	private TableView<Estudiante> tableEstudiantes;

	@FXML
	private TextField txtNombre;

	@FXML
	private Button btnEliminar;

	@FXML
	private TextField txtApellido;

	@FXML
	private Button btnActualizar;

	@FXML
	private ComboBox<TipoDocumento> cbTipoDocumento;

	//MONITOR
		ObservableList<Monitor> listaMonitoresData = FXCollections.observableArrayList();

		Monitor monitorSeleccionado;
		
		@FXML
		private TableColumn<Monitor, String> columnDocumentoM;

		@FXML
		private TextField txtDireccionM;
		
		@FXML
		private TextField txtSalarioM;

		@FXML
		private Button btnNuevoM;

		@FXML
		private TableColumn<Monitor, String> columnApellidoM;

		@FXML
		private TableColumn<Monitor, String> columnNombreM;

		@FXML
		private Button btnAgregarM;

		@FXML
		private TextField txtDocumentoM;

		@FXML
		private TableColumn<Monitor, String> columnDireccionM;
		
		@FXML
		private TableColumn<Monitor, String> columSalarioM;

		@FXML
		private TableView<Monitor> tableMonitoresM;

		@FXML
		private TextField txtNombreM;

		@FXML
		private Button btnEliminarM;

		@FXML
		private TextField txtApellidoM;

		@FXML
		private Button btnActualizarM;
		
		@FXML
		private TextField txtUsuario;
		
		@FXML
		private TextField txtPassword;
		
		//ELEMENTOS
		
		ObservableList<Elemento> listaElementosData = FXCollections.observableArrayList();

		Elemento elementoSeleccionado;
		
		@FXML
		private Button btnNuevoE;
		@FXML
		private Button btnAgregarE;
		@FXML
		private Button btnEliminarE;
		@FXML
		private Button btnActualizarE;

		@FXML
		private TableColumn<Elemento, String> columnNombreE;
		@FXML
		private TableColumn<Elemento, String> columnCodigoE;
		@FXML
		private TableColumn<Elemento, String> columCantidadDispoE;

		@FXML
		private TableView<Elemento> tableElementosE;
		
		@FXML
		private TextField txtNombreE;
		@FXML
		private TextField txtCodigoE;
		@FXML
		private TextField txtCantidadElementoE;
		
		
		//PRESTAMOS
		
		ObservableList<Prestamo> listaPrestamosData = FXCollections.observableArrayList();
		ObservableList<DetallePrestamo> listaElementosPrestamoData = FXCollections.observableArrayList();


		Prestamo prestamoSeleccionado;
		DetallePrestamo detallePSeleccionado;
		
		@FXML
		private Button btnAgregarPrestamo;
		@FXML
		private Button btnNuevoPrestamo;
		@FXML
		private Button btnNuevoElementoPres;
		@FXML
		private Button btnEliminarElementoPres;
		@FXML
		private Button btnAgregarElementoPres;
		@FXML
		private Button btnBuscarEstudiante;
		@FXML
		private Button btnBuscarElemento;
		@FXML
		private Button btnBuscarPrestamo;
		@FXML
		private Button btnEntregarPrestamo;
		
		@FXML
		private TableColumn<DetallePrestamo, String> columElemento;
		@FXML
		private TableColumn<DetallePrestamo, String> columCantidad;
		
		@FXML
		private TableView<DetallePrestamo> tableElementosP;
		
		@FXML
		private TextField txtEstudiante;
		@FXML
		private TextField txtNombreEstudiante;
		@FXML
		private TextField txtElemento;
		@FXML
		private TextField txtCantidadElementoPres;
		@FXML
		private TextField txtNombreCantidadEle;
		@FXML
		private DatePicker fechaPrestamo;
		@FXML
		private DatePicker fechaEntrega;
		@FXML
		private TextField txtCodigoPrestamo;
		

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio=laboratorio;
		inicializarTablas();
	}
 public void inicializarTablas() {

		tableEstudiantes.getItems().clear();
		tableEstudiantes.setItems(getListaEstudiantesData());
		tableMonitoresM.getItems().clear();
		tableMonitoresM.setItems(getListaMonitoresData());
		tableElementosE.getItems().clear();
		tableElementosE.setItems(getListaElementosData());
		tableElementosP.getItems().clear();
		tableElementosP.setItems(getListaDetallePrestamos());
 }
	
	@FXML
	void initialize() {
		this.columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
		this.columnDocumento.setCellValueFactory(new PropertyValueFactory<>("documento"));
		this.columnDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));

		tableEstudiantes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			estudianteSeleccionado = newSelection;

			mostrarInformacionEstudiante(estudianteSeleccionado);

		});

		cbTipoDocumento.getItems().addAll(TipoDocumento.CEDULA,TipoDocumento.PASAPORTE,TipoDocumento.CEDULA_EXTRANJERA);

		
		this.columnNombreM.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnApellidoM.setCellValueFactory(new PropertyValueFactory<>("apellido"));
		this.columnDocumentoM.setCellValueFactory(new PropertyValueFactory<>("documento"));
		this.columnDireccionM.setCellValueFactory(new PropertyValueFactory<>("direccion"));
		this.columSalarioM.setCellValueFactory(new PropertyValueFactory<>("salario"));
		

		tableMonitoresM.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			monitorSeleccionado = newSelection;

			mostrarInformacionMonitor(monitorSeleccionado);

		});
		
		this.columnNombreE.setCellValueFactory(new PropertyValueFactory<>("nombreElemento"));
		this.columnCodigoE.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		this.columCantidadDispoE.setCellValueFactory(new PropertyValueFactory<>("cantElemento"));

		tableElementosE.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			elementoSeleccionado = newSelection;

			mostrarInformacionElemento(elementoSeleccionado);

		});
		
		this.columElemento.setCellValueFactory(new PropertyValueFactory<>("nombreElemento"));
		this.columCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
		
		tableElementosP.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			detallePSeleccionado = newSelection;

			//mostrarInformacion de los elemento y del prestamo 
			mostarInformacionElementoPrestamo(detallePSeleccionado);
		});
	}

	
//ESTUDIANTES
	private ObservableList<Estudiante> getListaEstudiantesData() {
		listaEstudiantesData.addAll(laboratorio.getEstudiantes());
		return listaEstudiantesData;
	}
	@FXML
	void nuevoEstudiante(ActionEvent event) {
		txtNombre.setText("Ingrese el nombre");
		txtApellido.setText("Ingrese el apellidos");
		txtDocumento.setText("Ingrese el documento");
		txtDireccion.setText("Ingrese la direccion");
	}

	@FXML
	void agregarEstudiante(ActionEvent event) {
		crearEstudiante();
	}

	@FXML
	void actualizarEstudiante(ActionEvent event) {
		actualizarEstudiante();
	}

	@FXML
	void eliminarEstudiante(ActionEvent event) {

		eliminarEstudiante();
	}

	@FXML
	void seleccionarTipoDocumentoAction(ActionEvent event) {
		System.out.println("Action del combo");

		System.out.println(cbTipoDocumento.getValue());
	}
	private void crearEstudiante() {
		//1. capturar datos
		String nombre = txtNombre.getText();
		String apellido = txtApellido.getText();
		String documento = txtDocumento.getText();
		String direccion = txtDireccion.getText();


		//2. validar la informacion
		if(datosValidos(nombre,apellido,documento,direccion) == true){

			//3. registrar
			Estudiante estudiante = null;

			estudiante = laboratorio.crearEstudiante(nombre,apellido,documento,direccion);

			if(estudiante != null){

				listaEstudiantesData.add(estudiante);

				mostrarMensaje("Notificacion estudiante", "Estudiante registrado", "El estudiante se ha registrado con exito", AlertType.INFORMATION);
			}else{
				mostrarMensaje("Notificacion estudiante", "Estudiante No registrado", "El estudiante no se pudo registrar", AlertType.ERROR);
			}
		}



	}

	private void eliminarEstudiante() {

		boolean estudianteEliminado = false;

		if(estudianteSeleccionado != null){


			if(mostrarMensajeConfirmacion("¿Estas seguro de eliminar al estudiante?") == true){

				estudianteEliminado = laboratorio.eliminarEstudiante(estudianteSeleccionado.getDocumento());

				if(estudianteEliminado == true){
					listaEstudiantesData.remove(estudianteSeleccionado);
					estudianteSeleccionado = null;
					tableEstudiantes.getSelectionModel().clearSelection();
					limpiarCamposEstudiante();
					mostrarMensaje("Notificacion estudiante","Estudiante eliminado","Estudiante eliminado con exito", AlertType.INFORMATION);
				}else{
					mostrarMensaje("Notificacion estudiante","Estudiante no eliminado","Estudiante no se puede eliminar", AlertType.ERROR);
				}
			}

		}else{
			mostrarMensaje("Notificacion estudiante","Estudiante no seleccionado","Debe seleccionar un Estudiante", AlertType.WARNING);
		}
	}

	private void actualizarEstudiante() {
		//1. capturar datos
		String nombre = txtNombre.getText();
		String apellido = txtApellido.getText();
		String documento = txtDocumento.getText();
		String direccion = txtDireccion.getText();

		boolean estudianteActualizado = false;

		if(estudianteSeleccionado != null){

			if(datosValidos(nombre,apellido,documento,direccion) == true){

				estudianteActualizado = laboratorio.actualizarEstudiante(estudianteSeleccionado.getDocumento(),nombre,apellido,documento,direccion );

				if(estudianteActualizado == true){
					tableEstudiantes.refresh();
					mostrarMensaje("Notificacion Estudiante","Estudiante actualizado","Estudiante actualizado con exito", AlertType.INFORMATION);
				}else{
					mostrarMensaje("Notificacion Estudiante","Estudiante no actualizado","Estudiante no se puede actualizar", AlertType.ERROR);
				}
			}


		}else{
			mostrarMensaje("Notificacion estudiante","Estudiante no seleccionado","Debe seleccionar un estudiante", AlertType.WARNING);
		}

	}

	private void limpiarCamposEstudiante() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtDocumento.setText("");
		txtDireccion.setText("");
	}
	private void mostrarInformacionEstudiante(Estudiante estudianteSeleccionado) {
		if(estudianteSeleccionado != null){
			txtNombre.setText(estudianteSeleccionado.getNombre());
			txtApellido.setText(estudianteSeleccionado.getApellido());
			txtDocumento.setText(estudianteSeleccionado.getDocumento());
			txtDireccion.setText(estudianteSeleccionado.getDireccion());
		}
	}
	
	private boolean datosValidos(String nombre, String apellido, String documento,  String direccion) {

		String mensaje = "";

		if(nombre == null || nombre.equals(""))
			mensaje += "El nombre es invalido \n" ;

		if(apellido == null || apellido.equals(""))
			mensaje += "El apellido es invalido \n" ;

		if(documento == null || documento.equals(""))
			mensaje += "El documento es invalido \n" ;

		if(direccion == null || direccion.equals(""))
			mensaje += "La direccion es invalida \n" ;

		if(mensaje.equals("")){
			return true;
		}else{
			mostrarMensaje("Notificacion estudiante","Datos invalidos",mensaje, AlertType.WARNING);
			return false;
		}
	}
	
	//TODOS
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
		alert.setTitle("Confirmacion");
		alert.setContentText(mensaje);
		Optional<ButtonType> action = alert.showAndWait();

		if (action.get() == ButtonType.OK) {
			return true;
		} else {
			return false;
		}
	}

	
	//LIMPIAR CAMPOS
	public void mouseClicked(MouseEvent e){
        txtNombre.setText("");
       }
	public void mouseClicked1(MouseEvent e){
       txtApellido.setText("");
       }
	public void mouseClicked2(MouseEvent e){
		txtDocumento.setText("");
       }
	public void mouseClicked3(MouseEvent e){
		txtDireccion.setText("");
      }
	
	
	public void mouseClickedM(MouseEvent e){
		txtNombreM.setText("");
	}
	public void mouseClickedM1(MouseEvent e){
		txtApellidoM.setText("");
	}
	public void mouseClickedM2(MouseEvent e){
		txtDocumentoM.setText("");
	}
	public void mouseClickedM3(MouseEvent e){
		txtDireccionM.setText("");
	}
	public void mouseClickedM4(MouseEvent e){
		txtSalarioM.setText("");
	}
	public void mouseClickedM5(MouseEvent e){
	    txtUsuario.setText("");
	}
	public void mouseClickedM6(MouseEvent e){
		txtPassword.setText("");
	}
	
	
	public void mouseClickedE(MouseEvent e){
		txtNombreE.setText("");
	}
	public void mouseClickedE1(MouseEvent e){
        txtCodigoE.setText("");
	}
	public void mouseClickedE2(MouseEvent e){
		txtCantidadElementoE.setText("");
	}
	
	
	public void mouseClickedP(MouseEvent e) {
		txtEstudiante.setText("");
	}
	public void mouseClickedP1(MouseEvent e) {
		txtElemento.setText("");
	}	
	public void mouseClickedP2(MouseEvent e) {
		txtCantidadElementoPres.setText("");
	}
	public void mouseClickedP3(MouseEvent e) {
		txtNombreEstudiante.setText("");
	}
	public void mouseClickedP4(MouseEvent e) {
		fechaEntrega.getEditor().clear();
	}
	public void mouseClickedP5(MouseEvent e) {
        fechaPrestamo.getEditor().clear();
	}
	public void mouseClickedP6(MouseEvent e) {
		txtNombreCantidadEle.setText("");
	}
	public void mouseClickedP7(MouseEvent e) {
		txtCodigoPrestamo.setText("");
	}
	
	
	//MONITOR
	private ObservableList<Monitor> getListaMonitoresData() {
		listaMonitoresData.addAll(laboratorio.getMonitores());
		return listaMonitoresData;
	}


	@FXML
	void nuevoMonitor(ActionEvent event) {
		txtNombreM.setText("Ingrese el nombre");
		txtApellidoM.setText("Ingrese el apellidos");
		txtDocumentoM.setText("Ingrese el documento");
		txtDireccionM.setText("Ingrese la direccion");
		txtSalarioM.setText("Ingrese el salario");
		txtUsuario.setText("Ingrese el usuario");
		txtPassword.setText("Ingrese la contraseña");
	}

	@FXML
	void agregarMonitor(ActionEvent event) {
		crearMonitor();
	}


	@FXML
	void actualizarMonitor(ActionEvent event) {
		actualizarMonitor();
	}

	@FXML
	void eliminarMonitor(ActionEvent event) {

		eliminarMonitor();
	}

	private void crearMonitor() {


		//1. capturar datos
		String nombre = txtNombreM.getText();
		String apellido = txtApellidoM.getText();
		String documento = txtDocumentoM.getText();
		String direccion = txtDireccionM.getText();
		String salario= txtSalarioM.getText();
		String usuario= txtUsuario.getText();
		String password= txtPassword.getText();

		//2. validar la informacion
		if(datosValidos(nombre,apellido,documento,direccion,salario) == true){

			//3. registrar
			Monitor monitor = null;

			monitor = laboratorio.crearMonitor(nombre, apellido, documento, direccion, salario, usuario, password);

			if(monitor != null){

				listaMonitoresData.add(monitor);

				mostrarMensaje("Notificacion monitor", "monitor registrado", "El monitor se ha registrado con exito", AlertType.INFORMATION);
			}else{
				mostrarMensaje("Notificacion monitor", "monitor No registrado", "El monitor no se pudo registrar", AlertType.ERROR);
			}
		}



	}

	private void eliminarMonitor() {

		boolean monitorEliminado = false;

		if(monitorSeleccionado != null){


			if(mostrarMensajeConfirmacion("¿Estas seguro de eliminar al estudiante?") == true){

				monitorEliminado = laboratorio.eliminarMonitor(monitorSeleccionado.getDocumento());

				if(monitorEliminado == true){
					listaMonitoresData.remove(monitorSeleccionado);
					monitorSeleccionado = null;
					tableMonitoresM.getSelectionModel().clearSelection();
					limpiarCamposMonitor();
					mostrarMensaje("Notificacion monitor","monitor eliminado","monitor eliminado con exito", AlertType.INFORMATION);
				}else{
					mostrarMensaje("Notificacion monitor","monitor no eliminado","monitor no se puede eliminar", AlertType.ERROR);
				}
			}

		}else{
			mostrarMensaje("Notificacion monitor","monitor no seleccionado","Debe seleccionar un monitor", AlertType.WARNING);
		}
	}


	private void actualizarMonitor() {

		//1. capturar datos
		String nombre = txtNombreM.getText();
		String apellido = txtApellidoM.getText();
		String documento = txtDocumentoM.getText();
		String direccion = txtDireccionM.getText();
		String salario= txtSalarioM.getText();
		String usuario= txtUsuario.getText();
		String password= txtPassword.getText();

		boolean monitorActualizado = false;

		if(monitorSeleccionado != null){

			if(datosValidos(nombre, apellido, documento, direccion, salario) == true){

				monitorActualizado = laboratorio.actualizarMonitor(monitorSeleccionado.getDocumento(),nombre,apellido,documento,direccion, salario, usuario, password );

				if(monitorActualizado == true){
					tableMonitoresM.refresh();
					mostrarMensaje("Notificacion monitor","monitor actualizado","monitor actualizado con exito", AlertType.INFORMATION);
				}else{
					mostrarMensaje("Notificacion monitor","monitor no actualizado","monitor no se puede actualizar", AlertType.ERROR);
				}
			}

		}else{
			mostrarMensaje("Notificacion monitor","monitor no seleccionado","Debe seleccionar un monitor", AlertType.WARNING);
		}

	}


	private void limpiarCamposMonitor() {

		txtNombreM.setText("");
		txtApellidoM.setText("");
		txtDocumentoM.setText("");
		txtDireccionM.setText("");
		txtSalarioM.setText("");
		txtUsuario.setText("");
		txtPassword.setText("");
	}

	private void mostrarInformacionMonitor(Monitor monitorSeleccionado) {

		if(monitorSeleccionado != null){
			txtNombreM.setText(monitorSeleccionado.getNombre());
			txtApellidoM.setText(monitorSeleccionado.getApellido());
			txtDocumentoM.setText(monitorSeleccionado.getDocumento());
			txtDireccionM.setText(monitorSeleccionado.getDireccion());
			txtSalarioM.setText(monitorSeleccionado.getSalario());
			txtUsuario.setText(monitorSeleccionado.getUser());
			txtPassword.setText(monitorSeleccionado.getPassword());
		}
	}
	
	private boolean datosValidos(String nombre, String apellido, String documento,  String direccion, String salario) {

		String mensaje = "";


		if(nombre == null || nombre.equals(""))
			mensaje += "El nombre es invalido \n" ;

		if(apellido == null || apellido.equals(""))
			mensaje += "El apellido es invalido \n" ;

		if(documento == null || documento.equals(""))
			mensaje += "El documento es invalido \n" ;

		if(direccion == null || direccion.equals(""))
			mensaje += "La direccion es invalida \n" ;
		
		if(salario == null || salario.equals(""))
			mensaje += "El salario es invalido \n" ;

		if(mensaje.equals("")){
			return true;
		}else{
			mostrarMensaje("Notificacion monitor","Datos invalidos",mensaje, AlertType.WARNING);
			return false;
		}
	}
	
	
	//ELEMENTOS
	
	private ObservableList<Elemento> getListaElementosData() {
		listaElementosData.addAll(laboratorio.getElementos());
		return listaElementosData;
	}
	@FXML
	void nuevoElemento(ActionEvent event) {
		txtNombreE.setText("Ingrese el nombre");
		txtCodigoE.setText("Ingrese el codigo");
		txtCantidadElementoE.setText("Ingrese la cantidad");
	}
	

	@FXML
	void agregarElemento(ActionEvent event) {
		crearElemento();
	}

	@FXML
	void actualizarElemento(ActionEvent event) {
		actualizarElemento();
	}

	@FXML
	void eliminarElemento(ActionEvent event) {

		eliminarElemento();
	}

	private void crearElemento() {
		//1. capturar datos
		String nombre = txtNombreE.getText();
		String codigo = txtCodigoE.getText();
		int cantidadElementos = Integer.parseInt(txtCantidadElementoE.getText());


		//2. validar la informacion
		if(datosValidosE(nombre, codigo, cantidadElementos) == true){

			//3. registrar
			Elemento elemento = null;

			elemento = laboratorio.crearElemento(nombre, codigo, cantidadElementos);

			if(elemento != null){

				listaElementosData.add(elemento);

				mostrarMensaje("Notificacion elemento", "Elemento registrado", "El elemento se ha registrado con exito", AlertType.INFORMATION);
			}else{
				mostrarMensaje("Notificacion elemento", "Elemento No registrado", "El elemento no se pudo registrar", AlertType.ERROR);
			}
		}
	}

	private void eliminarElemento() {

		boolean elementoEliminado = false;

		if(elementoSeleccionado != null){


			if(mostrarMensajeConfirmacion("¿Estas seguro de eliminar al estudiante?") == true){

				elementoEliminado = laboratorio.eliminarElemento(elementoSeleccionado.getCodigo());

				if(elementoEliminado == true){
					listaElementosData.remove(elementoSeleccionado);
					elementoSeleccionado = null;
					tableElementosE.getSelectionModel().clearSelection();
					limpiarCamposElemento();
					mostrarMensaje("Notificacion Elemento","Elemento eliminado","Elemento eliminado con exito", AlertType.INFORMATION);
				}else{
					mostrarMensaje("Notificacion Elemento","Elemento no eliminado","Elemento no se puede eliminar", AlertType.ERROR);
				}
			}

		}else{
			mostrarMensaje("Notificacion Elemento","Elemento no seleccionado","Debe seleccionar un Elemento", AlertType.WARNING);
		}
	}

	private void actualizarElemento() {
		//1. capturar datos
		String nombre = txtNombreE.getText();
		String codigo = txtCodigoE.getText();
		int cantidadE = Integer.parseInt(txtCantidadElementoE.getText());

		boolean elementoActualizado = false;

		if(elementoSeleccionado != null){

			if(datosValidosE(nombre, codigo, cantidadE) == true){

				elementoActualizado = laboratorio.actualizarElemento(elementoSeleccionado.getCodigo(),nombre,codigo, cantidadE);

				if(elementoActualizado == true){
					tableElementosE.refresh();
					mostrarMensaje("Notificacion elemento","elemento actualizado","elemento actualizado con exito", AlertType.INFORMATION);
				}else{
					mostrarMensaje("Notificacion elemento","elemento no actualizado","elemento no se puede actualizar", AlertType.ERROR);
				}
			}


		}else{
			mostrarMensaje("Notificacion elemento","elemento no seleccionado","Debe seleccionar un elemento", AlertType.WARNING);
		}

	}

	private void limpiarCamposElemento() {
		txtNombreE.setText("");
		txtCodigoE.setText("");
		txtCantidadElementoE.setText("");
	}
	
	
	private void mostrarInformacionElemento(Elemento elementoSeleccionado) {
		if(elementoSeleccionado != null){
			txtNombreE.setText(elementoSeleccionado.getNombreElemento());
			txtCodigoE.setText(elementoSeleccionado.getCodigo());
			txtCantidadElementoE.setPromptText(String.valueOf(elementoSeleccionado.getCantElemento()));
		}
	}
	
	
	private boolean datosValidosE(String nombreE, String codigo, int cantidadElementos) {

		String mensaje = "";

		if(nombreE == null || nombreE.equals(""))
			mensaje += "El nombre es invalido \n" ;

		if(codigo == null || codigo.equals(""))
			mensaje += "El codigo es invalido \n" ;

		if(cantidadElementos == 0)
			mensaje += "La cantidad es invalida \n" ;

		if(mensaje.equals("")){
			return true;
		}else{
			mostrarMensaje("Notificacion elemento","Datos invalidos",mensaje, AlertType.WARNING);
			return false;
		}
	}
	

	//PRESTAMOS
	
	private ObservableList<Prestamo> getListaPrestamosData() {
		listaPrestamosData.addAll(laboratorio.getPrestamos());
		return listaPrestamosData;
	}
	
	private ObservableList<DetallePrestamo> getListaDetallePrestamos() {
		listaElementosPrestamoData.addAll(laboratorio.getDetallePrestamos());
		return listaElementosPrestamoData;
	}
	
	
	@FXML
	void nuevoPrestamo(ActionEvent event) {
		txtEstudiante.setText("Ingrese el documento del estudiante");
		txtNombreEstudiante.setText("");
		fechaEntrega.getEditor().clear();
		fechaPrestamo.getEditor().clear();
		txtCodigoPrestamo.setText("Ingrese el codigo del prestamo");
		nuevoElementoP(event);
	}
	
	
	@FXML
	void nuevoElementoP(ActionEvent event) {
		txtElemento.setText("Ingrese el elemento");
		txtCantidadElementoPres.setText("Ingrese la cantidad del elemento");
		txtNombreCantidadEle.setText("");
	}
	
	@FXML
	void buscarEstudiante(ActionEvent event) {
			buscarEstudianteP();				
	}
	
	@FXML
	void buscarElemento(ActionEvent event) {
		buscarElementoP();
	}
	
	@FXML
	void buscarPrestamo(ActionEvent event) {
		buscarPrestamo();
	}
	
	@FXML
	void agregarElementoPrestamo(ActionEvent event) {
		crearElementoPrestamo();
		
	}
	@FXML
	void agregarPrestamo(ActionEvent event) {
		crearPrestamo();
	}
	@FXML
	void eliminarElementoPres(ActionEvent event) {
		eliminarElementoPrestamo();
	}
	@FXML
	void entregarPrestamoP(ActionEvent event) {
		entregaPrestamo();
	}
	
	
	private void buscarEstudianteP() {
		String codigoEstudiante= txtEstudiante.getText();
		Estudiante estudiante= laboratorio.obtenerEstudiante(codigoEstudiante);
			if (estudiante!=null) {
				txtNombreEstudiante.setText(estudiante.getNombre());
				mostrarMensaje("Notificacion Estudiante P","estudiante encontrado","estudiante encontrado con exito", AlertType.INFORMATION);
			}	else {
				mostrarMensaje("Notificacion Estudiante P","estudiante no encontrado","estudiante no fue encontrado", AlertType.ERROR);
		}
	}
	
	private void buscarElementoP() {
		String codigoElemento= txtElemento.getText();
		Elemento elemento= laboratorio.obtenerElemento(codigoElemento);
			if (elemento!=null) {
				txtNombreCantidadEle.setText(elemento.getNombreElemento()+"  -   "+elemento.getCantElemento());
				mostrarMensaje("Notificacion elemento P","elemento encontrado","elemento encontrado con exito", AlertType.INFORMATION);
			}	else {
				mostrarMensaje("Notificacion elemento P","elemento no encontrado","elemento no fue encontrado", AlertType.ERROR);
			}	
	}
	
	private void buscarPrestamo() {
		String codigoPrestamo= txtCodigoPrestamo.getText();
		Prestamo prestamo= laboratorio.obtenerPrestamo(codigoPrestamo);
		if (prestamo!=null) {
			
			mostrarInformacionPrestamo(prestamo);
			mostrarMensaje("Notificacion Prestamo","Prestamo encontrado","Prestamo encontrado con exito", AlertType.INFORMATION);

		} else {
			mostrarMensaje("Notificacion Prestamo","Prestamo no encontrado","Prestamo no fue encontrado con exito", AlertType.ERROR);
		}
	}
	
	

	private void crearElementoPrestamo() {
		
		String codigoElemento= txtElemento.getText();
		int cantidad= Integer.parseInt(txtCantidadElementoPres.getText());
		
		Elemento elemento=laboratorio.obtenerElemento(codigoElemento);
		boolean centinela = laboratorio.validarEstadoElemento(codigoElemento, cantidad);
		
		
		if (centinela==true && elemento!=null) {
			
			DetallePrestamo dp= new DetallePrestamo(elemento, cantidad);
			
			if(dp != null){
				listaElementosPrestamoData.add(dp);
				buscarElementoP();
				limpiarCamposElementoP();
				mostrarMensaje("Notificacion elemento prestamo", "elemento Prestamo registrado", "El elemento del prestamo se ha registrado con exito", AlertType.INFORMATION);
			} 
		} else {
			mostrarMensaje("Notificacion elemento prestamo", "elemento Prestamo no registrado", "El elemento del prestamo no se ha registrado", AlertType.ERROR);
		}
		
	}
	
	
	private void mostrarInformacionPrestamo(Prestamo prestamoSeleccionado) {
		if(prestamoSeleccionado != null){	
		txtEstudiante.setText(prestamoSeleccionado.getEstudiante().getDocumento());
		txtNombreEstudiante.setText(prestamoSeleccionado.getEstudiante().getNombre());
		fechaPrestamo.setValue(prestamoSeleccionado.getFechaPrestamo());
		fechaEntrega.setValue(prestamoSeleccionado.getFechaEntrega());
		txtCodigoPrestamo.setText(prestamoSeleccionado.getCodigoPrestamo());
	
		for (Prestamo prestamo: listaPrestamosData ) {
			for (DetallePrestamo detallePrestamo : elementosPrestamo) {
				columElemento.setText(detallePrestamo.getNombreElemento());
				columCantidad.setText(detallePrestamo.getCantidad()+"");
				}
			}
		}
	}
	
	
	private void mostarInformacionElementoPrestamo(DetallePrestamo detallePSeleccionado) {
		if (detallePSeleccionado!=null) {
			txtNombreCantidadEle.setText(detallePSeleccionado.getElemento().getNombreElemento()+"  -  "+detallePSeleccionado.getElemento().getCantElemento());
			txtElemento.setText(detallePSeleccionado.getElemento().getCodigo());
			txtCantidadElementoPres.setText(detallePSeleccionado.getCantidad()+"");
		}
	}
	
	ArrayList<DetallePrestamo> elementosPrestamo= new ArrayList<>();
	
	private void crearPrestamo() {
		
		String codigoEstudiante= txtEstudiante.getText();
		Estudiante estudiante= laboratorio.obtenerEstudiante(codigoEstudiante);
		LocalDate fechaP= fechaPrestamo.getValue();
		LocalDate fechaE= fechaEntrega.getValue();
		
		if (estudiante!=null) {
			if (listaElementosPrestamoData!=null) {
				Prestamo prestamo=null;
				prestamo= laboratorio.crearPrestamo(estudiante, monitorLogin, elementosPrestamo, fechaP, fechaE, codigoEstudiante);
			if (prestamo!=null) {
				listaPrestamosData.add(prestamo);
				limpiarCamposPrestamo();
				mostrarMensaje("Notificacion prestamo", "Prestamo registrado", "El prestamo se ha registrado con exito", AlertType.INFORMATION);
			} 
			
			}else {
				mostrarMensaje("Notificacion elemento prestamo", "Prestamo no registrado", "El prestamo no se ha registrado", AlertType.ERROR);

			}
		}
		
	}

	private void eliminarElementoPrestamo() {

		boolean elementoEliminado = false;

		if(detallePSeleccionado != null){

			if(mostrarMensajeConfirmacion("¿Estas seguro de eliminar al estudiante?") == true){

				elementoEliminado = laboratorio.eliminarElementoPrestamo(detallePSeleccionado.getElemento().getCodigo());

				if(elementoEliminado == true){
					listaElementosPrestamoData.remove(detallePSeleccionado);
					detallePSeleccionado = null;
					tableElementosP.getSelectionModel().clearSelection();
					limpiarCamposElementoP();
					mostrarMensaje("Notificacion elemento P","elemento P eliminado","elemento P eliminado con exito", AlertType.INFORMATION);
				}else{
					mostrarMensaje("Notificacion elemento P","elemento P no eliminado","elemento P no se puede eliminar", AlertType.ERROR);
				}
			}

		}else{
			mostrarMensaje("Notificacion elemento P","elemento P no seleccionado","Debe seleccionar un elemento P", AlertType.WARNING);
		}
	}

	private void limpiarCamposElementoP() {
		txtElemento.setText("");
		txtCantidadElementoPres.setText("");
		txtNombreCantidadEle.setText("");
	}
	
	private void limpiarCamposPrestamo() {
		txtEstudiante.setText("");
		txtNombreEstudiante.setText("");
		fechaPrestamo.getEditor().clear();
		fechaEntrega.getEditor().clear();
		txtCodigoPrestamo.setText("");
		limpiarCamposElementoP();
	}
	
	
	private void entregaPrestamo() {
		String codigoPrestamo= txtCodigoPrestamo.getText();
		Prestamo prestamo= laboratorio.obtenerPrestamo(codigoPrestamo);
		if (listaPrestamosData!=null) {
			if (prestamo!=null) {
				boolean centinela= laboratorio.devolverPrestamo(codigoPrestamo);
				if (centinela==true) {
					listaPrestamosData.remove(prestamo);
					limpiarCamposPrestamo();
					mostrarMensaje("Notificacion prestamo entregado", "Prestamo entragado", "El prestamo se ha entragado con exito", AlertType.INFORMATION);
				}
			}else {
				mostrarMensaje("Notificacion prestamo", "Prestamo entregado", "El prestamo se ha entregado con exito", AlertType.ERROR);

			}
			
		}
	}
}
