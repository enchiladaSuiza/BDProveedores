package vistas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bdproveedores.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import modelos.ModeloTabla;

public class ControladorMain extends Controlador {
	@FXML
	private ComboBox<String> combo;
	
	@FXML
	private BorderPane borderPane;
	
	@FXML
	private TextField textField;
	
	private TableView<String> tablaGenerica;
	private TableView<Proveedor> tablaProveedores;
	private ModeloTabla modelo;
	private List<String> nombresTablas;
	
	@Override
	public void init() {
		modelo = new ModeloTabla();
		
		nombresTablas = new ArrayList<>();
		nombresTablas.addAll(Arrays.asList("Proveedor",
				"Compra",
				"Pieza",
				"ProveedorPieza",
				"ArticuloCompra"));
		combo.getItems().addAll(nombresTablas);
		combo.getSelectionModel().selectFirst();
	}
	
	@FXML
	private void eleccionComboBox() {
		String eleccion = combo.getValue();
		if (eleccion.equals(nombresTablas.get(0))) {
			generarTablaProveedores();
			System.out.println("Mostrando Proveedores");
		}
	}
	
	// Llamada al presionar enter en el TextField
	@FXML
	public void generarTablaGenerica() {
		if (tablaGenerica == null) {
			tablaGenerica = new TableView<String>();
		}
		tablaGenerica.getItems().clear();
		tablaGenerica.getColumns().clear();
		
		String jpql = textField.getText();
		ObservableList<List<String>> resultados = modelo.popularGenerico(jpql);
		
		// Las columnas son el primer arreglo
		for (int i = 0; i < resultados.get(0).size(); i++) {
			TableColumn<String, String> columna = new TableColumn<>("C" + i);
			columna.setCellValueFactory(new PropertyValueFactory<>("C" + 1));
			tablaGenerica.getColumns().add(columna);
		}
		
		resultados.remove(0);
		for (List<String> fila : resultados) {
			tablaGenerica.getItems().addAll(fila);
		}
	}
	
	// LLamada al seleccionar "Proveedor" en la ComboBox
	public void generarTablaProveedores() {
		if (tablaProveedores == null) {
			tablaProveedores = new TableView<>();
			tablaProveedores.setPlaceholder(new Label(""));
			tablaProveedores.prefWidth(TableView.USE_COMPUTED_SIZE);
			tablaProveedores.maxWidth(TableView.USE_COMPUTED_SIZE);
			
			// Columnas
			for (String nombreColumna : modelo.getColumnasProveedores()) {
				TableColumn<Proveedor, String> columna = new TableColumn<>(nombreColumna);
				columna.setCellValueFactory(new PropertyValueFactory<>(nombreColumna));
				// columna.setPrefWidth(TableView.USE_COMPUTED_SIZE);
				tablaProveedores.getColumns().add(columna);
			}
		}
		
		tablaProveedores.getItems().addAll(modelo.popularProveedores());
		borderPane.setCenter(tablaProveedores);
	}
}
