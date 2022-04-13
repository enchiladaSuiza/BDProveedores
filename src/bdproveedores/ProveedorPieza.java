/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdproveedores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class ProveedorPieza implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    private String idProverdorPieza;
    private double precio;
    
    @OneToMany
    @JoinColumn(name="articuloCompra_proveedorPieza",nullable=false)
    private List<ArticuloCompra> proveedorPieza_articuloCompra=new ArrayList<ArticuloCompra>();
    
    @ManyToOne
    @JoinColumn(name = "proveedor_proveedorPieza", nullable = false)
    private Proveedor proveedorPieza_proveedor;
    
    @ManyToOne
    @JoinColumn(name = "pieza_proveedorPieza", nullable = false)
    private Pieza proveedorPieza_pieza;
    
    public ProveedorPieza(){
        this.idProverdorPieza="0";
        this.precio=0.0D;
    }

    public ProveedorPieza(String idProverdorPieza, double precio) {
        this.idProverdorPieza = idProverdorPieza;
        this.precio = precio;
    }
    
    public String toStringProveedor() {
        return String.format("\n-----\nId: %s "
                + "\nPrecio: %.2f "
                + "\nProovedor: %b \n",
                this.idProverdorPieza, this.precio, this.proveedorPieza_proveedor);
    }
    
    public String toStringPieza() {
        return String.format("\n-----\nId: %s "
                + "\nPrecio: %.2f "
                + "\nPieza: %b \n",
                this.idProverdorPieza, this.precio, this.proveedorPieza_pieza);
    }
    
    public String toStringArticuloCompra() {
        return String.format("\n-----\nId: %s "
                + "\nPrecio: %.2f "
                + "\nPieza: %b \n",
                this.idProverdorPieza, this.precio,this.getProveedorPieza_articuloCompra());
    }
    
    public void printArticuloCompra(){
        System.out.println("Compra de artículos: "+getProveedorPieza_articuloCompra().size());
        
        for (int i=0;i<getProveedorPieza_articuloCompra().size();i++) {
            System.out.println(getProveedorPieza_articuloCompra().get(i));
        }
    }
    
    public void formProveedorPieza_articuloCompra(ArticuloCompra cc){
        getProveedorPieza_articuloCompra().add(cc);
    }
    
    public void formProveedorPieza_pieza(Pieza pie) {
        proveedorPieza_pieza = pie;
    }
    
    public void formProveedorPieza_proveedor(Proveedor prov) {
        proveedorPieza_proveedor = prov;
    }

    public String getIdProverdorPieza() {
        return idProverdorPieza;
    }

    public void setIdProverdorPieza(String idProverdorPieza) {
        this.idProverdorPieza = idProverdorPieza;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<ArticuloCompra> getProveedorPieza_articuloCompra() {
        return proveedorPieza_articuloCompra;
    }

    public Proveedor getProveedorPieza_proveedor() {
        return proveedorPieza_proveedor;
    }

    public void setProveedorPieza_proveedor(Proveedor proveedorPieza_proveedor) {
        this.proveedorPieza_proveedor = proveedorPieza_proveedor;
    }

    public Pieza getProveedorPieza_pieza() {
        return proveedorPieza_pieza;
    }

    public void setProveedorPieza_pieza(Pieza proveedorPieza_pieza) {
        this.proveedorPieza_pieza = proveedorPieza_pieza;
    }
    
}
