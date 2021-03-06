package calculator.gui;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorApp extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/calculator.fxml"));
		Scene scene = new Scene(root, 600, 400);
		stage.setTitle("Calculator2");
		stage.setScene(scene);
		stage.show();
	}

}
