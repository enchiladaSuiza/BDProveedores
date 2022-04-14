package modelos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bdproveedores.*;
import consultas.Consultas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModeloTabla {
	private Consultas consultas;
	private List<String> columnasProveedores,
		columnasCompras,
		columnasPieza,
		columnasProveedorPieza,
		columnasArticuloCompra;
	
	public List<String> getColumnasProveedores() { return columnasProveedores; }
	public List<String> getColumnasCompras() { return columnasCompras; }
	public List<String> getColumnasPieza() { return columnasPieza; }
	public List<String> getColumnasProveedorPieza() { return columnasProveedorPieza; }
	public List<String> getColumnasArticuloCompra() { return columnasArticuloCompra; }

	public ModeloTabla() {
		consultas = new Consultas();
		columnasProveedores = Arrays.asList("Nombre de la empresa",
				"Nombre del proveedor", 
				"Ciudad",
				"Estado", 
				"Dirección", 
				"Teléfono", 
				"Correo");
		columnasCompras = Arrays.asList("Número de compta",
				"Número de factora",
				"Fecha",
				"Total");
		columnasPieza = Arrays.asList("Nombre",
				"Material",
				"Color",
				"Dimensiones",
				"Descripción",
				"Categoría");
		columnasProveedorPieza = Arrays.asList("ID ProveedoresPieza",
				"Precio");
		columnasArticuloCompra = Arrays.asList("Subtotal",
				"Precio",
				"Cantidad");
	}
	
	public ObservableList<List<String>> popularGenerico(String jpql) {
		ObservableList<List<String>> datos = FXCollections.observableArrayList();
		List<String[]> resultados = consultas.consultaGenerica(jpql);
		List<String> columnas = new ArrayList<>();
		for (int i = 0; i < resultados.get(0).length; i ++) {
			columnas.add("C" + i);
		}
		
		datos.add(columnas);
		for (String[] resultado : resultados) {
			datos.add(Arrays.asList(resultado));
		}
		return datos;
	}
	
	public ObservableList<Proveedor> popularProveedores() {
		ObservableList<Proveedor> datos = FXCollections.observableArrayList();
		datos.addAll(consultas.consultaProveedores());
		return datos;
	}
	
	public ObservableList<Compra> popularCompras() {
		ObservableList<Compra> datos = FXCollections.observableArrayList();
		datos.addAll(consultas.consultaCompras());
		return datos;
	}
	
	public ObservableList<Pieza> popularPiezas() {
		ObservableList<Pieza> datos = FXCollections.observableArrayList();
		datos.addAll(consultas.consultaPiezas());
		return datos;
	}
	
	public ObservableList<ProveedorPieza> popularProveedorPieza() {
		ObservableList<ProveedorPieza> datos = FXCollections.observableArrayList();
		datos.addAll(consultas.consultaProveedorPiezas());
		return datos;
	}
	
	public ObservableList<ArticuloCompra> popularArtiuloCompra() {
		ObservableList<ArticuloCompra> datos = FXCollections.observableArrayList();
		datos.addAll(consultas.consultaArticuloCompras());
		return datos;
	}
}
