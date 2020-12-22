package dad.javafx.complex;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {
	
	private ComplexField complejo;
	
	@FXML
	private VBox view;
	
	@FXML
	private Label texto;
	
	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		complejo = new ComplexField();
		
		view.getChildren().add(complejo);
		
		texto.textProperty().bind(
				Bindings.concat(
						complejo.realProperty(),
						"+",
						complejo.imaginaryProperty(),
						"i"
					)
				);
	}
	
	public VBox getView() {
		return view;
	}

}
