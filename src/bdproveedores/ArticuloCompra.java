/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdproveedores;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class ArticuloCompra implements Serializable {
    private static final long serialVersionUID=1L;
    
    @Id
    private double subtotal;
    private double precio;
    private int cantidad;
    
    @ManyToOne
    @JoinColumn(name = "compra_articuloCompra", nullable = false)
    private Compra articuloCompra_compra;
    
    @ManyToOne
    @JoinColumn(name = "proveedorPieza_articuloCompra", nullable = false)
    private ProveedorPieza articuloCompra_proveedorPieza;
    
    @ManyToOne
    @JoinColumn(name = "pieza_articuloCompra", nullable = false)
    private Pieza articuloCompra_pieza;
    
    public ArticuloCompra(){
        this.subtotal=0.0D;
        this.precio=0.0D;
        this.cantidad=0;
    }
    
    public ArticuloCompra(double subTotal,double precio,int cantidad){
        this.subtotal=subTotal;
        this.precio=precio;
        this.cantidad=cantidad;
    }
    
    public String toStringCompra() {
        return String.format("\n-----\nCantidad: %d "
                + "\nsubtotal: %.2f "
                + "\nprecio: %.2f "
                + "\nCompras: %b \n",
                this.cantidad, this.subtotal, this.precio,this.articuloCompra_compra);
    }
    
    public String toStringProveedorPieza() {
        return String.format("\n-----\nCantidad: %d "
                + "\nsubtotal: %.2f "
                + "\nprecio: %.2f "
                + "\nProveedorPieza: %b \n",
                this.cantidad, this.subtotal, this.precio,this.articuloCompra_proveedorPieza);
    }
    
    public String toStringPieza() {
        return String.format("\n-----\nCantidad: %d "
                + "\nsubtotal: %.2f "
                + "\nprecio: %.2f "
                + "\nPiezas: %b \n",
                this.cantidad, this.subtotal, this.precio,this.articuloCompra_pieza);
    }
    
    public void formArticuloCompra_compra(Compra cc) {
        articuloCompra_compra = cc;
    }
    
    public void formArticuloCompra_proveedorPieza(ProveedorPieza pp) {
        articuloCompra_proveedorPieza = pp;
    }
    
    public void formArticuloCompra_proveedorPieza(Pieza pie) {
        articuloCompra_pieza = pie;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Compra getArticuloCompra_compra() {
        return articuloCompra_compra;
    }

    public void setArticuloCompra_compra(Compra articuloCompra_compra) {
        this.articuloCompra_compra = articuloCompra_compra;
    }

    public ProveedorPieza getArticuloCompra_proveedorPieza() {
        return articuloCompra_proveedorPieza;
    }

    public void setArticuloCompra_proveedorPieza(ProveedorPieza articuloCompra_proveedorPieza) {
        this.articuloCompra_proveedorPieza = articuloCompra_proveedorPieza;
    }

    public Pieza getArticuloCompra_pieza() {
        return articuloCompra_pieza;
    }

    public void setArticuloCompra_pieza(Pieza articuloCompra_pieza) {
        this.articuloCompra_pieza = articuloCompra_pieza;
    }       
}