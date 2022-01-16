package co.edu.cue.empresaalimentos.application;
	
import java.io.IOException;

import co.edu.cue.empresaalimentos.controller.EmpresaAlimentoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Aplicacion extends Application {
	
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {

			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Empresa de Alimentos");
			mostrarVentanaPrincipal();

		}
	public static void main(String[] args) {
        launch(args);
    }
	
	
	private void mostrarVentanaPrincipal() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../view/EmpresaAlimentosView.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			EmpresaAlimentoController empresaAlimentoController = loader.getController();

			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	  
}
