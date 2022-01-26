package co.edu.cue.drogueria.controller;

import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.cue.drogueria.application.Aplicacion;
import co.edu.cue.drogueria.model.Cliente;
import co.edu.cue.drogueria.model.Domicilio;
import co.edu.cue.drogueria.model.Empleado;
import co.edu.cue.drogueria.model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.net.URL;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class DrogueriaController {

	Aplicacion aplicacion;
	ModelFactoryController modelFactory;
	CrudClienteViewController crudClienteViewController;
	CrudEmpleadoViewController crudEmpleadoViewController;
	CrudDrogaViewController crudDrogaViewController;
	
	ObservableList<Empleado> listaEmpleadosData= FXCollections.observableArrayList();
	Empleado empleadoSeleccionado;
	
	ObservableList<Cliente> listaClientesData= FXCollections.observableArrayList();
	Cliente clienteSeleccionado;
	
	ObservableList<Producto> listaProductosData= FXCollections.observableArrayList();
	Producto productoSeleccionado;
	
	ObservableList<Domicilio> listaDomiciliosData= FXCollections.observableArrayList();
	Domicilio domicilioSeleccionado;
	
	public ObservableList<Empleado> getListaEmpleadosData() {
		listaEmpleadosData.addAll(crudEmpleadoViewController.obtenerEmpleado());
		return listaEmpleadosData;
	}

	public void setListaEmpleadosData(ObservableList<Empleado> listaEmpleadosData) {
		this.listaEmpleadosData = listaEmpleadosData;
	}

	public ObservableList<Cliente> getListaClientesData() {
		listaClientesData.addAll(crudClienteViewController.obtenerCliente());
		return listaClientesData;
	}

	public void setListaClientesData(ObservableList<Cliente> listaClientesData) {
		this.listaClientesData = listaClientesData;
	}

	public ObservableList<Producto> getListaProductosData() {
		listaProductosData.addAll(crudDrogaViewController.obtenerProducto());
		return listaProductosData;
	}

	public void setListaProductosData(ObservableList<Producto> listaProductosData) {
		this.listaProductosData = listaProductosData;
	}

	public ObservableList<Domicilio> getListaDomiciliosData() {
		return listaDomiciliosData;
	}

	public void setListaDomiciliosData(ObservableList<Domicilio> listaDomiciliosData) {
		this.listaDomiciliosData = listaDomiciliosData;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Domicilio, String> colNumeroDomicilio;

    @FXML
    private TextField txtCodigoP;

    @FXML
    private Button btnNuevoE;

    @FXML
    private Button btnNuevoC;

    @FXML
    private Button btnNuevoD;

    @FXML
    private TableColumn<Domicilio, String> colClienteD;

    @FXML
    private Button btnActualizarC;

    @FXML
    private Button btnAgregarD;

    @FXML
    private Button btnAgregarC;

    @FXML
    private Button btnAgregarE;

    @FXML
    private TextField txtCorreoE;

    @FXML
    private TextField txtClienteD;

    @FXML
    private TableView<Empleado> tableEmpleado;

    @FXML
    private Button btnNuevoP;

    @FXML
    private TextField txtCorreoC;

    @FXML
    private TableColumn<Empleado, String> colCedulaE;

    @FXML
    private Button btnAgregarP;

    @FXML
    private Button btnActualizarE;

    @FXML
    private TableColumn<Cliente, String> colCedulaC;

    @FXML
    private Button btnActualizarD;

    @FXML
    private Button btnActualizarP;

    @FXML
    private TextField txtSalarioE;

    @FXML
    private TableColumn<Cliente, String> colNombreC;

    @FXML
    private TextField txtNombreC;

    @FXML
    private TextField txtDireccionC;

    @FXML
    private TableColumn<Empleado, String> colNombreE;

    @FXML
    private TextField txtNombreE;

    @FXML
    private TableColumn<Empleado, String> colSalarioE;

    @FXML
    private TextField txtTelefonoC;

    @FXML
    private TableView<Cliente> tableCliente;

    @FXML
    private TableColumn<Cliente, String> colCorreoC;

    @FXML
    private TableColumn<Empleado, String> colCorreoE;

    @FXML
    private TextField txtNombreP;

    @FXML
    private TextField txtCedulaE;

    @FXML
    private TextField txtCedulaC;

    @FXML
    private TableColumn <Cliente, String> colTelefonoC;

    @FXML
    private Button btnEliminarE;

    @FXML
    private TableColumn<Cliente, String> colDireccionC;

    @FXML
    private TextField txtEmpleadoD;

    @FXML
    private Button btnEliminarD;

    @FXML
    private Button btnEliminarC;

    @FXML
    private TextField txtTelefonoE;

    @FXML
    private TextField txtCantidadP;

    @FXML
    private TableColumn<Empleado, String> colEmpleadoD;

    @FXML
    private TableColumn<Producto, String> colNombreP;

    @FXML
    private Button btnEliminarP;

    @FXML
    private TableColumn<Producto, String> colCodigoP;

    @FXML
    private TextField txtNumDomicilio;

    @FXML
    private TableColumn<Domicilio, String> colProductoD;

    @FXML
    private TableColumn<Empleado, String> colTelefonoE;

    @FXML
    private TextField txtFechaD;

    @FXML
    private TableColumn<Domicilio, String> colFechaD;

    @FXML
    private TextField txtProductoD;

    @FXML
    private TableView<Producto> tableProducto;

    @FXML
    private TableView<Domicilio> tableDomicilio;

    @FXML
    private TextField txtValorUniP;

    @FXML
    private TableColumn<Producto, String> colValorUnidadP;

    @FXML
    void initialize() {
    	
    	modelFactory= ModelFactoryController.getInstance();
    	crudClienteViewController= new CrudClienteViewController(modelFactory);
    	crudEmpleadoViewController= new CrudEmpleadoViewController(modelFactory);
    	crudDrogaViewController= new CrudDrogaViewController(modelFactory);
    	
    	inicializarEmpleadoView();
    	inicializarClienteView();
    	inicializarProductoView();
    	//inicializarDomicilioView();
    }
    
    private void inicializarDomicilioView() {

    	this.colClienteD.setCellValueFactory(new PropertyValueFactory<>("cliente.getNombre"));
    	this.colEmpleadoD.setCellValueFactory(new PropertyValueFactory<>("empleado.getNombre"));
    	this.colProductoD.setCellValueFactory(new PropertyValueFactory<>("producto.getNombre"));
    	this.colNumeroDomicilio.setCellValueFactory(new PropertyValueFactory<>("numeroDomicilio"));
    	this.colFechaD.setCellValueFactory(new PropertyValueFactory<>("fecha"));
    	
    	tableDomicilio.getItems().clear();
    	tableDomicilio.setItems(getListaDomiciliosData());
    	
    	tableDomicilio.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			domicilioSeleccionado = newSelection;

			mostrarInformacionDomicilio(domicilioSeleccionado);
		});
	}
	private void mostrarInformacionDomicilio(Domicilio domicilioSeleccionado) {
		if(domicilioSeleccionado != null){
			txtNumDomicilio.setText(domicilioSeleccionado.getNumeroDomicilio());
			txtFechaD.setText(domicilioSeleccionado.getFecha());
			txtClienteD.setText(domicilioSeleccionado.getCliente().getCedula());
			txtEmpleadoD.setText(domicilioSeleccionado.getEmpleado().getCedula());
			txtProductoD.setText(domicilioSeleccionado.getProducto().getCodigo());
		}
	}
	
	private void inicializarProductoView() {
		this.colNombreP.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.colCodigoP.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		this.colValorUnidadP.setCellValueFactory(new PropertyValueFactory<>("valorU"));

		tableProducto.getItems().clear();
		tableProducto.setItems(getListaProductosData());
		
		tableProducto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			productoSeleccionado = newSelection;

			mostrarInformacionProducto(productoSeleccionado);
		});
	}

    private void mostrarInformacionProducto(Producto productoSeleccionado) {
		if(productoSeleccionado != null){
			txtNombreP.setText(productoSeleccionado.getNombre());
			txtCodigoP.setText(productoSeleccionado.getCodigo());
			txtValorUniP.setText(productoSeleccionado.getValorU());
			txtCantidadP.setPromptText(String.valueOf(productoSeleccionado.getCantExis()));
		}
		
	}
    
	private void inicializarClienteView() {
		this.colNombreC.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.colCedulaC.setCellValueFactory(new PropertyValueFactory<>("cedula"));
		this.colTelefonoC.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		this.colCorreoC.setCellValueFactory(new PropertyValueFactory<>("correoE"));
		this.colDireccionC.setCellValueFactory(new PropertyValueFactory<>("direccion"));

		tableCliente.getItems().clear();
		tableCliente.setItems(getListaClientesData());
		
		tableCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			clienteSeleccionado = newSelection;

			mostrarInformacionCliente(clienteSeleccionado);
		});
	}
	
	private void mostrarInformacionCliente(Cliente clienteSeleccionado) {
		if(clienteSeleccionado != null){
			txtNombreC.setText(clienteSeleccionado.getNombre());
			txtCedulaC.setText(clienteSeleccionado.getCedula());
			txtTelefonoC.setText(clienteSeleccionado.getTelefono());
			txtCorreoC.setText(clienteSeleccionado.getCorreoE());
			txtDireccionC.setText(clienteSeleccionado.getDireccion());
		}
		
	}

	private void inicializarEmpleadoView() {
    	
		this.colNombreE.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.colCedulaE.setCellValueFactory(new PropertyValueFactory<>("cedula"));
		this.colTelefonoE.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		this.colCorreoE.setCellValueFactory(new PropertyValueFactory<>("correoE"));
		this.colSalarioE.setCellValueFactory(new PropertyValueFactory<>("salario"));

		tableEmpleado.getItems().clear();
		tableEmpleado.setItems(getListaEmpleadosData());
		
		tableEmpleado.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			empleadoSeleccionado = newSelection;

			mostrarInformacionEmpleado(empleadoSeleccionado);

		});
	}

private void mostrarInformacionEmpleado(Empleado empleadoSeleccionado) {
		if(empleadoSeleccionado != null){
			txtNombreE.setText(empleadoSeleccionado.getNombre());
			txtCedulaE.setText(empleadoSeleccionado.getCedula());
			txtTelefonoE.setText(empleadoSeleccionado.getTelefono());
			txtCorreoE.setText(empleadoSeleccionado.getCorreoE());
			txtSalarioE.setText(empleadoSeleccionado.getSalario());
		}
		
	}

	public void setAplicacion(Aplicacion aplicacion) {
	this.aplicacion = aplicacion;
	}
	
	
	@FXML
    void actualizarEmpleadoAction(ActionEvent event) {

		actualizarEmpleado();
    }

    private void actualizarEmpleado() {
    	String nombre= txtNombreE.getText();
    	String cedula= txtCedulaE.getText();
    	String telefono= txtTelefonoE.getText();
    	String correo= txtCorreoE.getText();
    	String salario= txtSalarioE.getText();
    	boolean empleadoActualizado= false;
    	
    	if (empleadoSeleccionado!=null) {
			if (datosValidosEmpleado(nombre, cedula, telefono, correo, salario)) {
				
				empleadoActualizado= crudEmpleadoViewController.actualizarEmpleado(empleadoSeleccionado.getCedula(), nombre, cedula, telefono, correo, salario);
				if (empleadoActualizado==true) {
					tableEmpleado.refresh();
        			mostrarMensaje("Notificación empleado", "Empleado actualizado", "El empleado se ha actualizado con éxito", AlertType.INFORMATION);
        			limpiarCamposEmpleado();
				}else {
        			mostrarMensaje("Notificación empleado", "Empleado no actualizado", "El empleado no se ha actualizado con éxito", AlertType.INFORMATION);
				}
			}else {
        		mostrarMensaje("Notificación empleado", "Empleado no creado", "Los datos ingresados son invalidos", AlertType.ERROR);
			}
		}else {
    		mostrarMensaje("Notificación empleado", "Empleado no actualizado", "El empleado no ha sido seleccionado", AlertType.ERROR);
		}
	}

	@FXML
    void eliminarEmpleadoAction(ActionEvent event) {

    	eliminarEmpleado();
    }

    private void eliminarEmpleado() {

    	boolean empleadoEliminado= false;
    	if (empleadoSeleccionado!=null) {
			if (mostrarMensajeConfirmacion("¿Estas seguro de elmininar al empleado?")) {
				empleadoEliminado= crudEmpleadoViewController.eliminarEmpleado(empleadoSeleccionado.getCedula());
				if (empleadoEliminado==true) {
					listaEmpleadosData.remove(empleadoSeleccionado);
					empleadoSeleccionado=null;
					
					tableEmpleado.getSelectionModel().clearSelection();
					limpiarCamposEmpleado();
					mostrarMensaje("Notificación empleado", "Empleado eliminado", "El empleado se ha eliminado con éxito", AlertType.INFORMATION);
				} else {
					mostrarMensaje("Notificación empleado", "Empleado no eliminado", "El empleado no se puede eliminar", AlertType.ERROR);
				}
			}
		}else {
			mostrarMensaje("Notificación empleado", "Empleado no seleccionado", "Seleccione un empleado de la lista", AlertType.WARNING);
		}
	}

    
	@FXML
    void agregarEmpleadoAction(ActionEvent event) {

    	agregarEmpleado();
    }
    
    
    private void agregarEmpleado() {

    	String nombre= txtNombreE.getText();
    	String cedula= txtCedulaE.getText();
    	String telefono= txtTelefonoE.getText();
    	String correo= txtCorreoE.getText();
    	String salario= txtSalarioE.getText();
    	
    	if (datosValidosEmpleado(nombre, cedula, telefono, correo, salario)== true) {
			Empleado empleado= null;
			empleado= crudEmpleadoViewController.crearEmpleado(nombre, cedula, telefono, correo, salario);
			if (empleado!=null) {
				listaEmpleadosData.add(empleado);
				crudEmpleadoViewController.guardarDatos();
				mostrarMensaje("Notificacion empleado", "Empleado creado", "El empleado se ha creado con exito", AlertType.INFORMATION);
				limpiarCamposEmpleado();
			} else {
				mostrarMensaje("Notificación empleado", "Empleado no creado", "El empleado no se ha creado con éxito", AlertType.INFORMATION);
			}
		}else {
			mostrarMensaje("Notificación empleado", "Empleado no creado", "Los datos ingresados no son invalidos", AlertType.ERROR);
		}
	}

	@FXML
    void nuevoEmpleadoAction(ActionEvent event) {

    	txtNombreE.setText("Ingrese el nombre");
    	txtCedulaE.setText("Ingrese la cedula");
    	txtTelefonoE.setText("Ingrese el telefono");
    	txtCorreoE.setText("Ingrese el correo");
    	txtSalarioE.setText("Ingrese el salario");
    }

    @FXML
    void agregarProductoAction(ActionEvent event) {
    	agregarProducto();
    }

    private void agregarProducto() {
    	String nombre= txtNombreP.getText();
    	String codigo= txtCodigoP.getText();
    	String valorU= txtValorUniP.getText();
    	int cantidad= Integer.parseInt(txtCantidadP.getText());
    			
    	if (datosValidosProducto(nombre, codigo, valorU, cantidad)== true) {
			Producto producto= null;
			producto= crudDrogaViewController.crearProducto(nombre, codigo, valorU, cantidad);
			if (producto!=null) {
				listaProductosData.add(producto);
				crudDrogaViewController.guardarDatos();
				mostrarMensaje("Notificacion producto", "Producto creado", "El producto se ha creado con exito", AlertType.INFORMATION);
				limpiarCamposProducto();
			} else {
				mostrarMensaje("Notificación producto", "Producto no creado", "El producto no se ha creado con éxito", AlertType.INFORMATION);
			}
		}else {
			mostrarMensaje("Notificación producto", "producto no creado", "Los datos ingresados no son invalidos", AlertType.ERROR);
		}
	}

	@FXML
    void actualizarProductoAction(ActionEvent event) {
		actualizarProducto();
    }

    private void actualizarProducto() {
    	String nombre= txtNombreP.getText();
    	String codigo= txtCodigoP.getText();
    	String valorU= txtValorUniP.getText();
    	int cantidad = Integer.parseInt(txtCantidadP.getText());
    	boolean productoActualizado= false;
    	
    	if (productoSeleccionado!=null) {
			if (datosValidosProducto(nombre, codigo, valorU, cantidad)) {
				
				productoActualizado= crudDrogaViewController.actualizarProducto(productoSeleccionado.getCodigo(), nombre, codigo, valorU, cantidad);
				if (productoActualizado==true) {
					tableProducto.refresh();
        			mostrarMensaje("Notificación producto", "Producto actualizado", "El producto se ha actualizado con éxito", AlertType.INFORMATION);
        			limpiarCamposEmpleado();
				}else {
        			mostrarMensaje("Notificación producto", "Producto no actualizado", "El producto no se ha actualizado con éxito", AlertType.INFORMATION);
				}
			}else {
        		mostrarMensaje("Notificación producto", "Producto no creado", "Los datos ingresados son invalidos", AlertType.ERROR);
			}
		}else {
    		mostrarMensaje("Notificación producto", "Producto no actualizado", "El producto no ha sido seleccionado", AlertType.ERROR);
		}
	}

	@FXML
    void eliminarProductoAction(ActionEvent event) {
    	eliminarProducto();
    }

    private void eliminarProducto() {
    	boolean productoEliminado= false;
    	if (productoSeleccionado!=null) {
			if (mostrarMensajeConfirmacion("¿Estas seguro de elmininar el producto?")) {
				productoEliminado= crudDrogaViewController.eliminarProducto(productoSeleccionado.getCodigo());
				if (productoEliminado==true) {
					
					listaProductosData.remove(productoSeleccionado);
					productoSeleccionado=null;
					
					tableProducto.getSelectionModel().clearSelection();
					limpiarCamposProducto();
					mostrarMensaje("Notificación producto", "Producto eliminado", "El producto se ha eliminado con éxito", AlertType.INFORMATION);
				} else {
					mostrarMensaje("Notificación producto", "Producto no eliminado", "El producto no se puede eliminar", AlertType.ERROR);
				}
			}
		}else {
			mostrarMensaje("Notificación producto", "Producto no seleccionado", "Seleccione un producto de la lista", AlertType.WARNING);
		}
	}

	@FXML
    void nuevoProductoAction(ActionEvent event) {

    	txtNombreP.setText("Ingrese el nombre");
    	txtCodigoP.setText("Ingrese el codigo");
    	txtValorUniP.setText("Ingrese el valor por unidad");
    	txtCantidadP.setText("Ingrese la cantidad");
    }

    @FXML
    void agregarClienteAction(ActionEvent event) {
    	agregarCliente();
    }

    private void agregarCliente() {

    	String nombre= txtNombreC.getText();
    	String cedula= txtCedulaC.getText();
    	String telefono= txtTelefonoC.getText();
    	String correo= txtCorreoC.getText();
    	String direccion= txtDireccionC.getText();
    	
    	if (datosValidosCliente(nombre, cedula, telefono, correo, direccion)== true) {
			Cliente cliente= null;
			cliente= crudClienteViewController.crearCliente(nombre, cedula, telefono, correo, direccion);
			if (cliente!=null) {
				listaClientesData.add(cliente);
				crudClienteViewController.guardarDatos();
				mostrarMensaje("Notificacion cliente", "Cliente creado", "El cliente se ha creado con exito", AlertType.INFORMATION);
				limpiarCamposEmpleado();
			} else {
				mostrarMensaje("Notificación cliente", "Cliente no creado", "El cliente no se ha creado con éxito", AlertType.INFORMATION);
			}
		}else {
			mostrarMensaje("Notificación cliente", "Cliente no creado", "Los datos ingresados no son invalidos", AlertType.ERROR);
		}
	}

	@FXML
    void actualizarClienteAction(ActionEvent event) {

    	actualizarCliente();
    }

    private void actualizarCliente() {

    	String nombre= txtNombreC.getText();
    	String cedula= txtCedulaC.getText();
    	String telefono= txtTelefonoC.getText();
    	String correo= txtCorreoC.getText();
    	String direccion= txtDireccionC.getText();
    	boolean clienteActualizado= false;
    	
    	if (clienteSeleccionado!=null) {
			if (datosValidosCliente(nombre, cedula, telefono, correo, direccion)) {
				
				clienteActualizado= crudClienteViewController.actualizarCliente(clienteSeleccionado.getCedula(), nombre, cedula, telefono, correo, direccion);
				if (clienteActualizado==true) {
					tableCliente.refresh();
        			mostrarMensaje("Notificación cliente", "Cliente actualizado", "El cliente se ha actualizado con éxito", AlertType.INFORMATION);
        			limpiarCamposEmpleado();
				}else {
        			mostrarMensaje("Notificación cliente", "Cliente no actualizado", "El cliente no se ha actualizado con éxito", AlertType.INFORMATION);
				}
			}else {
        		mostrarMensaje("Notificación cliente", "Cliente no creado", "Los datos ingresados son invalidos", AlertType.ERROR);
			}
		}else {
    		mostrarMensaje("Notificación cliente", "Cliente no actualizado", "El cliente no ha sido seleccionado", AlertType.ERROR);
		}
	}

	@FXML
    void eliminarClienteAction(ActionEvent event) {
		eliminarCliente();
    }

    private void eliminarCliente() {
    	boolean clienteEliminado= false;
    	if (clienteSeleccionado!=null) {
			if (mostrarMensajeConfirmacion("¿Estas seguro de elmininar al cliente?")) {
				clienteEliminado= crudClienteViewController.eliminarCliente(clienteSeleccionado.getCedula());
				if (clienteEliminado==true) {
					listaClientesData.remove(clienteSeleccionado);
					clienteSeleccionado=null;
					
					tableCliente.getSelectionModel().clearSelection();
					limpiarCamposCliente();
					mostrarMensaje("Notificación cliente", "Cliente eliminado", "El cliente se ha eliminado con éxito", AlertType.INFORMATION);
				} else {
					mostrarMensaje("Notificación cliente", "Cliente no eliminado", "El cliente no se puede eliminar", AlertType.ERROR);
				}
			}
		}else {
			mostrarMensaje("Notificación cliente", "Cliente no seleccionado", "Seleccione un cliente de la lista", AlertType.WARNING);
		}
	}

	@FXML
    void nuevoClienteAction(ActionEvent event) {

    	txtNombreC.setText("Ingrese el nombre");
    	txtCedulaC.setText("Ingrese la cedula");
    	txtTelefonoC.setText("Ingrese el telefono");
    	txtCorreoC.setText("Ingrese el correo");
    	txtDireccionC.setText("Ingrese la direccion");
    }

    @FXML
    void agregarDomicilioAction(ActionEvent event) {

    }

    @FXML
    void actualizarDomicilioAction(ActionEvent event) {

    }

    @FXML
    void eliminarDomicilioAction(ActionEvent event) {

    }

    @FXML
    void nuevoDomicilioAction(ActionEvent event) {

    	txtNumDomicilio.setText("Ingrese el numero");
    	txtFechaD.setText("Ingrese la fecha");
    	txtClienteD.setText("Ingrese la cedula del cliente");
    	txtEmpleadoD.setText("Ingrese la cedula del empleado");
    	txtProductoD.setText("Ingrese el codigo del producto");
    }

    private void limpiarCamposEmpleado() {
    	txtNombreE.setText("");
    	txtCedulaE.setText("");
    	txtTelefonoE.setText("");
    	txtCorreoE.setText("");
    	txtSalarioE.setText("");
	}
    private void limpiarCamposCliente() {
    	txtNombreC.setText("");
    	txtCedulaC.setText("");
    	txtTelefonoC.setText("");
    	txtCorreoC.setText("");
    	txtDireccionC.setText("");
	}
    private void limpiarCamposProducto() {
    	txtNombreP.setText("");
    	txtCodigoP.setText("");
    	txtValorUniP.setText("");
    	txtCantidadP.setText("");
    }
    private void limpiarCamposDomicilio() {
    	txtNumDomicilio.setText("");
    	txtFechaD.setText("");
    	txtClienteD.setText("");
    	txtEmpleadoD.setText("");
    	txtProductoD.setText("");
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
    
    private boolean datosValidosEmpleado(String nombre, String cedula, String telefono,  String correo, String salario) {

		String mensaje = "";
 

		if(nombre == null || nombre.equals(""))
			mensaje += "El nombre es invalido \n" ;

		if(cedula == null || cedula.equals(""))
			mensaje += "La cedula es invalida \n" ;

		if(telefono == null || telefono.equals(""))
			mensaje += "El telefono es invalido \n" ;

		if(correo == null || correo.equals(""))
			mensaje += "El correo es invalida \n" ;
		
		if(salario == null || salario.equals(""))
			mensaje += "El correo es invalida \n" ;
		
		if(mensaje.equals("")){
			return true;
		}else{
			mostrarMensaje("Notificación empleado","Datos invalidos",mensaje, AlertType.WARNING);
			return false;
		}
	}
    private boolean datosValidosCliente(String nombre, String cedula, String telefono,  String correo, String direccion) {

		String mensaje = "";
 
		if(nombre == null || nombre.equals(""))
			mensaje += "El nombre es invalido \n" ;

		if(cedula == null || cedula.equals(""))
			mensaje += "La cedula es invalida \n" ;

		if(telefono == null || telefono.equals(""))
			mensaje += "El telefono es invalido \n" ;

		if(correo == null || correo.equals(""))
			mensaje += "El correo es invalida \n" ;
		
		if(direccion == null || direccion.equals(""))
			mensaje += "La direccion es invalida \n" ;
		
		if(mensaje.equals("")){
			return true;
		}else{
			mostrarMensaje("Notificación cliente","Datos invalidos",mensaje, AlertType.WARNING);
			return false;
		}
	}
    
    private boolean datosValidosProducto(String nombre, String codigo, String valorUnidad,  int cantidad) {

		String mensaje = "";
 
		if(nombre == null || nombre.equals(""))
			mensaje += "El nombre es invalido \n" ;

		if(codigo == null || codigo.equals(""))
			mensaje += "El codigo es invalido \n" ;

		if(valorUnidad == null || valorUnidad.equals(""))
			mensaje += "El telefono es invalido \n" ;

		if(cantidad <= 0 )
			mensaje += "La cantidad es invalida \n" ;
		
		if(mensaje.equals("")){
			return true;
		}else{
			mostrarMensaje("Notificación producto","Datos invalidos",mensaje, AlertType.WARNING);
			return false;
		}
	}
}
