package co.edu.cue.banco;
	
import java.io.IOException;

import co.edu.cue.banco.controllers.BancoViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Aplicacion extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Banco UQ");
		mostrarVentanaPrincipal();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	/** * Initializes the root layout. */
	public void mostrarVentanaPrincipal() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("view/BancoView.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();
			BancoViewController bancoViewController = loader.getController();

			bancoViewController.setAplicacion(this);

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			//scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
}
