/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdproveedores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Compra implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    private long noCompra;
    private long noFactura;
    @Temporal(TemporalType.DATE) private Date fecha;
    private int total;
    
    @ManyToOne
    @JoinColumn(name = "proveedor_compra", nullable = false)
    private Proveedor compra_proveedor;
    
    @OneToMany
    @JoinColumn(name="articuloCompra_compra",nullable=false)
    private List<ArticuloCompra> compra_articuloCompra=new ArrayList<ArticuloCompra>();
    
    public Compra() {
        this.noCompra=0;
        this.noFactura=0;
        this.fecha=new Date();//fecha actual
        this.total=0;              
    }
    
    public Compra(long noCom, long noFac, Date fech, int tot) {
        this.noCompra=noCom;
        this.noFactura=noFac;
        this.fecha=fech;
        this.total=tot;
    }
    
    
    public String toStringProvedor(){
        return String.format("\n-----\nNúmero compra: %d "
                + "\nNúmero factura: %d"
                + "\nFecha: "+fecha
                + "\ntotal: %d"
                + "\nProveedor: %b \n",
                this.noCompra, this.noFactura, this.total, this.compra_proveedor);
    }
    
    public String toStringArticuloCompra() {
        return String.format("\n-----\nNúmero compra: %d "
                + "\nNúmero factura: %d"
                + "\nFecha: "+fecha
                + "\ntotal: %d"
                + "\nArticuloCompras: %b \n",
                this.noCompra, this.noFactura, this.total, this.getCompra_articuloCompra());
    }
    
    public void formCompra_proveedor(Proveedor prov){
        compra_proveedor = prov;
    }

    public long getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(long noFactura) {
        this.noFactura = noFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Proveedor getCompra_proveedor() {
        return compra_proveedor;
    }

    public void setCompra_proveedor(Proveedor compra_proveedor) {
        this.compra_proveedor = compra_proveedor;
    }
    
    
    public void printArticuloCompra(){
        System.out.println("Compra de articulos: "+getCompra_articuloCompra().size());
        
        for (int i=0;i<getCompra_articuloCompra().size();i++) {
            System.out.println(getCompra_articuloCompra().get(i));
        }
    }
    
    public void formCompra_articuloCompra(ArticuloCompra ac){
        getCompra_articuloCompra().add(ac);
    }
    
    public List<ArticuloCompra> getCompra_articuloCompra() {
        return compra_articuloCompra;
    }
}