
package bdproveedores;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

@Entity
public class Proveedor implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id   
    private String nomEmpresa;
    private String nomProveedor;
    private String coordenadas;
    private String ciudad;
    private String estado;
    private String direccion;
    private String telefono;
    private String correo;
    
    @OneToMany
    @JoinColumn(name="compra_proveedor",nullable=false)
    private List<Compra> proveedor_compra=new ArrayList<Compra>();
    
    @OneToMany
    @JoinColumn(name="proveedorPieza_proveedor",nullable=false)
    private List<ProveedorPieza> proveedor_proveedorPieza=new ArrayList<ProveedorPieza>();
     
    
    public Proveedor(){}

    public Proveedor(String nomEmpresa, String nomProveedor, String coordenadas, String ciudad, String estado, String direccion, String telefono, String correo) {
        this.nomEmpresa = nomEmpresa;
        this.nomProveedor = nomProveedor;
        this.coordenadas = coordenadas;
        this.ciudad = ciudad;
        this.estado = estado;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }
    
    
    public String toStringCompras() {
        return String.format("\n------\nNombre de la empresa: %s"
                + "\nNombre del proveedor: %s"
                + "\nCoordenadas: %s"
                + "\nCiudad: %s"
                + "\nEstado: %s"
                + "\nDirección: %s"
                + "\nTeléfono: %s"
                + "\nCorreo: %s"
                + "\nCompras: %b",
                this.nomEmpresa, this.nomProveedor,
                this.coordenadas, this.ciudad,
                this.estado, this.direccion,
                this.telefono, this.correo,
                this.getProveedor_compra());
    }
    
    public String toStringProveedorPieza() {
        return String.format("\n------\nNombre de la empresa: %s"
                + "\nNombre del proveedor: %s"
                + "\nCoordenadas: %s"
                + "\nCiudad: %s"
                + "\nEstado: %s"
                + "\nDirección: %s"
                + "\nTeléfono: %s"
                + "\nCorreo: %s"
                + "\nCompras: %b",
                this.nomEmpresa, this.nomProveedor,
                this.coordenadas, this.ciudad,
                this.estado, this.direccion,
                this.telefono, this.correo,
                this.getProveedor_proveedorPieza());
    }
    
    public void printCompras(){
        System.out.println("Compras: "+getProveedor_compra().size());
        
        for (int i=0;i<getProveedor_compra().size();i++) {
            System.out.println(getProveedor_compra().get(i));
        }
    }
    
    public void printProveedorPieza(){
        System.out.println("Piezas a proveer: "+getProveedor_proveedorPieza().size());
        
        for (int i=0;i<getProveedor_proveedorPieza().size();i++) {
            System.out.println(getProveedor_proveedorPieza().get(i));
        }
    }
        
    public void formProveedor_compra(Compra com){
        getProveedor_compra().add(com);
    }
    
    public void formProveedor_compra(ProveedorPieza pp){
        getProveedor_proveedorPieza().add(pp);
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getNomProveedor() {
        return nomProveedor;
    }

    public void setNomProveedor(String nomProveedor) {
        this.nomProveedor = nomProveedor;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Compra> getProveedor_compra() {
        return proveedor_compra;
    }

    public List<ProveedorPieza> getProveedor_proveedorPieza() {
        return proveedor_proveedorPieza;
    }
      
    
}
