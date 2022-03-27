package co.edu.cue.drogueria.application;

import java.io.IOException;

import co.edu.cue.drogueria.controller.DrogueriaController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Aplicacion extends  Application {

	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {

			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Drogueria");
			mostrarVentanaPrincipal();
		}
	
	public static void main(String[] args) {
        launch(args);
    }
	
	
	private void mostrarVentanaPrincipal() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../view/DrogView.fxml"));
			

			AnchorPane rootLayout = (AnchorPane)loader.load();

			DrogueriaController drogueriaController = loader.getController();

			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
