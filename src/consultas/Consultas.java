package consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import bdproveedores.*;

public class Consultas {
	EntityManager em;
	
	public Consultas() {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("$objectdb/db/proveedoresdb.odb");
		em = emf.createEntityManager();
	}
	
	public List<String[]> consultaGenerica(String jpql) {
		TypedQuery<String[]> consulta = em.createQuery(jpql, String[].class);
		return consulta.getResultList();
	}
	
	private <T> List<T> consultaClase(Class<T> clase) {
		String jpql = "SELECT x FROM " + clase.getName() + " x";
		TypedQuery<T> consulta = em.createQuery(jpql, clase);
		return consulta.getResultList();
	}
	
	public List<Proveedor> consultaProveedores() { 
		return consultaClase(Proveedor.class);
	}
	
	public List<Compra> consultaCompras() { 
		return consultaClase(Compra.class);
	}
	public List<Pieza> consultaPiezas() { 
		return consultaClase(Pieza.class);
	}
	
	public List<ArticuloCompra> consultaArticuloCompras() {
		return consultaClase(ArticuloCompra.class);
	}
	
	public List<ProveedorPieza> consultaProveedorPiezas() {
		return consultaClase(ProveedorPieza.class);
	}
}
