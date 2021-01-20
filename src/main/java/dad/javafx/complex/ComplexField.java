package dad.javafx.complex;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.util.converter.NumberStringConverter;

public class ComplexField extends HBox implements Initializable {

	// properties

	private DoubleProperty real = new SimpleDoubleProperty();
	private DoubleProperty imaginary = new SimpleDoubleProperty();

	// view
	
	@FXML
	private TextField realText;

	@FXML
	private TextField imaginaryText;

	public ComplexField() {
		super();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ComplexField.fxml"));
			loader.setController(this);
			loader.setRoot(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		realText.textProperty().bindBidirectional(real, new NumberStringConverter());
		imaginaryText.textProperty().bindBidirectional(imaginary, new NumberStringConverter());

	}

	public final DoubleProperty realProperty() {
		return this.real;
	}

	public final double getReal() {
		return this.realProperty().get();
	}

	public final void setReal(final double real) {
		this.realProperty().set(real);
	}

	public final DoubleProperty imaginaryProperty() {
		return this.imaginary;
	}

	public final double getImaginary() {
		return this.imaginaryProperty().get();
	}

	public final void setImaginary(final double imaginary) {
		this.imaginaryProperty().set(imaginary);
	}

}
