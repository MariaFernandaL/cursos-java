package co.edu.cue.lab.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.edu.cue.lab.Main;
import co.edu.cue.lab.exception.PasswordException;
import co.edu.cue.lab.exception.UserException;
import co.edu.cue.lab.model.Laboratorio;
import co.edu.cue.lab.model.Monitor;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class LoginController {

	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
	@FXML
	private Button btnLogin;
	
	@FXML
	private TextField txtUsuario;
	
	@FXML
	private PasswordField pSwContraseña;
	
	Laboratorio laboratorio;
	
	
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio=laboratorio;
	}
	
	
	@FXML
    private void eventKey(KeyEvent event){
        
        Object evt = event.getSource();
        
        if(evt.equals(txtUsuario)){
            
            if(event.getCharacter().equals(" ")){
                event.consume();
            }
        
        }else if(evt.equals(pSwContraseña)){

            if(event.getCharacter().equals(" ")){
                event.consume();
            }            
        }
    }
	
	public void eventLogin(Event e) throws IOException, UserException {
		
		String user=txtUsuario.getText();
		String password=pSwContraseña.getText();
		
		try {
			Monitor centinela= laboratorio.validarUsuario(user, password);

			if (centinela!=null) {
				FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/LabView.fxml"));
				Scene scene= new Scene(loader.load());
				LabController labController= loader.getController();
				labController.setLaboratorio(laboratorio);
				labController.setMonitorLogin(centinela);
				Stage stage=(Stage)((Node) e.getSource()).getScene().getWindow();
				stage.setScene(scene);
				stage.show();
			} else {
				JOptionPane.showMessageDialog(null, "El usuario y/o contraseña son incorrectos");
			}

		} catch (UserException ee) {
			mostrarMensaje("Error login", "Error", ee.getMessage(), AlertType.ERROR);
		}
		
		
	}
	
	private void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

		Alert aler = new Alert(alertType);
		aler.setTitle(titulo);
		aler.setHeaderText(header);
		aler.setContentText(contenido);
		aler.showAndWait();
	}
}
