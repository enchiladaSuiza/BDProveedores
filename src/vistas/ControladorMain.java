package vistas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class ControladorMain extends Controlador {
	@FXML
	private TableView<String> tabla;
	
	@FXML
	private ComboBox<String> combo;
	
	@Override
	public void init() {
		tabla.setPlaceholder(new Label(""));
		
		ObservableList<String> nombresTablas = FXCollections.observableArrayList();
		nombresTablas.addAll("Proveedor", "Compra", "Pieza", "ProveedorPieza", "ArticuloCompra");
		combo.getItems().addAll(nombresTablas);
		combo.getSelectionModel().selectFirst();
	}
}
