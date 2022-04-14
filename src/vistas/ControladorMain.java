package vistas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bdproveedores.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import modelos.*;

public class ControladorMain extends Controlador {
	@FXML
	private ComboBox<String> combo;
	
	@FXML
	private BorderPane borderPane;
	
	@FXML
	private TextField textField;
	
	@FXML
	private Button insertar;
	
	private TableView<String> tablaGenerica;
	private TableView<Proveedor> tablaProveedores;
	private TableView<Compra> tablaCompras;
	private TableView<Pieza> tablaPiezas;
	private TableView<ProveedorPieza> tablaProveedorPieza;
	private TableView<ArticuloCompra> tablaArticuloCompra;
	
	private ModeloTabla modeloTabla;
	private ModeloInsertar modeloInsertar;
	private List<String> nombresTablas;
	
	@Override
	public void init() {
		modeloTabla = new ModeloTabla();
		modeloInsertar = new ModeloInsertar();
		
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
		else if (eleccion.equals(nombresTablas.get(1))) {
			generarTablaCompras();
			System.out.println("Mostrando Compras");
		}
		else if (eleccion.equals(nombresTablas.get(2))) {
			generarTablaPiezas();
			System.out.println("Mostrando Piezas");
		}
		else if (eleccion.equals(nombresTablas.get(3))) {
			generarTablaProveedorPieza();
			System.out.println("Mostrando ProveedorPieza");
		}
		else if (eleccion.equals(nombresTablas.get(4))) {
			generarTablaArticuloCompra();
			System.out.println("Mostrando ArticuloCompra");
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
		ObservableList<List<String>> resultados = modeloTabla.popularGenerico(jpql);
		
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
	
	private <T> void prepararTableView(TableView<T> tabla, List<String> columnas, Class<T> clase) {
		tabla.setPlaceholder(new Label(""));
		tabla.prefWidth(TableView.USE_COMPUTED_SIZE);
		tabla.maxWidth(TableView.USE_COMPUTED_SIZE);
		
		for (String nombreColumna : columnas) {
			TableColumn<T, String> columna = new TableColumn<>(nombreColumna);
			columna.setCellValueFactory(new PropertyValueFactory<>(nombreColumna));
			// columna.setPrefWidth(TableView.USE_COMPUTED_SIZE);
			tabla.getColumns().add(columna);
		}
	}
	
	// LLamada al seleccionar "Proveedor" en la ComboBox
	public void generarTablaProveedores() {
		if (tablaProveedores == null) {
			tablaProveedores = new TableView<>();
			prepararTableView(tablaProveedores, modeloTabla.getColumnasProveedores(), Proveedor.class);
		}
		tablaProveedores.getItems().addAll(modeloTabla.popularProveedores());
		borderPane.setCenter(tablaProveedores);
	}
	
	public void generarTablaCompras() {
		if (tablaCompras == null) {
			tablaCompras = new TableView<>();
			prepararTableView(tablaCompras, modeloTabla.getColumnasCompras(), Compra.class);
		}
		tablaCompras.getItems().addAll(modeloTabla.popularCompras());
		borderPane.setCenter(tablaCompras);
	}
	
	public void generarTablaPiezas() {
		if (tablaPiezas == null) {
			tablaPiezas = new TableView<>();
			prepararTableView(tablaPiezas, modeloTabla.getColumnasPieza(), Pieza.class);
		}
		tablaPiezas.getItems().addAll(modeloTabla.popularPiezas());
		borderPane.setCenter(tablaPiezas);
	}
	
	public void generarTablaProveedorPieza() {
		if (tablaProveedorPieza == null) {
			tablaProveedorPieza = new TableView<>();
			prepararTableView(tablaProveedorPieza, 
					modeloTabla.getColumnasProveedorPieza(), 
					ProveedorPieza.class);
		}
		tablaProveedorPieza.getItems().addAll(modeloTabla.popularProveedorPieza());
		borderPane.setCenter(tablaProveedorPieza);
	}
	
	public void generarTablaArticuloCompra() {
		if (tablaArticuloCompra == null) {
			tablaArticuloCompra = new TableView<>();
			prepararTableView(tablaArticuloCompra, 
					modeloTabla.getColumnasArticuloCompra(), 
					ArticuloCompra.class);
		}
		tablaArticuloCompra.getItems().addAll(modeloTabla.popularArtiuloCompra());
		borderPane.setCenter(tablaArticuloCompra);
	}
	
	@FXML
	public void insertar() {
		modeloInsertar.insertar();
	}
}
