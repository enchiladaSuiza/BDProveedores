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
public class Pieza implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    private String nombre;
    private String material;
    private String color;
    private String dimenciones;
    private String descripcion;
    private String categoria;
    
    @OneToMany
    @JoinColumn(name="articuloCompra_pieza",nullable=false)
    private List<ArticuloCompra> pieza_articuloCompra=new ArrayList<ArticuloCompra>();
    
    @OneToMany
    @JoinColumn(name="proveedorPieza_pieza",nullable=false)
    private List<ProveedorPieza> pieza_proveedorPieza=new ArrayList<ProveedorPieza>();
    
    public Pieza(){}

    public Pieza(String nombre, String material, String color, String dimenciones, String descripcion, String categoria) {
        this.nombre = nombre;
        this.material = material;
        this.color = color;
        this.dimenciones = dimenciones;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }
    
    public String toStringArticuloCompra() {
        return String.format("\n-----\nNombre: %s "
                + "\nMaterial: %s "
                + "\nColor: %s "
                + "\nDimenciones: %s "
                + "\nDescripción: %s "
                + "\nCategoría: %s "
                + "\nArticuloCompras: %b \n",
                this.nombre,this.material,this.color,this.dimenciones,
                this.descripcion,this.categoria, this.getPieza_articuloCompra());
    }
    public String toStringProveedorPieza() {
        return String.format("\n-----\nNombre: %s "
                + "\nMaterial: %s "
                + "\nColor: %s "
                + "\nDimenciones: %s "
                + "\nDescripción: %s "
                + "\nCategoría: %s "
                + "\nArticuloCompras: %b \n",
                this.nombre,this.material,this.color,this.dimenciones,
                this.descripcion,this.categoria, this.getPieza_proveedorPieza());
    }
    
    public void printArticuloCompra(){
        System.out.println("Compra de artículos: "+getPieza_articuloCompra().size());
        
        for (int i=0;i<getPieza_articuloCompra().size();i++) {
            System.out.println(getPieza_articuloCompra().get(i));
        }
    }
    
    public void printProveedorPieza(){
        System.out.println("Piezas a proveer: "+getPieza_proveedorPieza().size());
        
        for (int i=0;i<getPieza_proveedorPieza().size();i++) {
            System.out.println(getPieza_proveedorPieza().get(i));
        }
    }
    public void formPieza_articuloCompra(ArticuloCompra ac){
        getPieza_articuloCompra().add(ac);
    }
    public void formPieza_proveedorPieza(ProveedorPieza pp){
        getPieza_proveedorPieza().add(pp);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDimenciones() {
        return dimenciones;
    }

    public void setDimenciones(String dimenciones) {
        this.dimenciones = dimenciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<ArticuloCompra> getPieza_articuloCompra() {
        return pieza_articuloCompra;
    }

    public List<ProveedorPieza> getPieza_proveedorPieza() {
        return pieza_proveedorPieza;
    }
    
}
