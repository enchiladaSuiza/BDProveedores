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
	private List<String> columnasProveedores;
	
	public List<String> getColumnasProveedores() { return columnasProveedores; }

	public ModeloTabla() {
		consultas = new Consultas();
		columnasProveedores = Arrays.asList("Nombre de la empresa",
				"Nombre del proveedor", 
				"Ciudad",
				"Estado", 
				"Dirección", 
				"Teléfono", 
				"Correo");
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
}
