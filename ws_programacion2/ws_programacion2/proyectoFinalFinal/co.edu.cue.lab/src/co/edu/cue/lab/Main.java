package co.edu.cue.lab;
	
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import co.edu.cue.lab.controller.LoginController;
import co.edu.cue.lab.model.Laboratorio;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {

	
	private Stage primaryStage;
	
	Laboratorio laboratorio = new Laboratorio("Fisica");


	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Laboratorio Ingenieria");
		
		mostrarVentanaPrincipal();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void mostrarVentanaPrincipal() throws IOException {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/loginMonitor.fxml"));
			Scene scene = new Scene(loader.load());
			
			LoginController controller= loader.getController();
			controller.setLaboratorio(laboratorio);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (FileNotFoundException e) {
			System.out.println("Se hallo una excepcion, no se encuentra el archivo FXML");
			//e.printStackTrace();
		}
	}
	
}