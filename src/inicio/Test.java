package inicio;

import javax.persistence.*;

import bdproveedores.*;

import java.util.*;


public class Test {

    public void Crear() {
        Scanner num = new Scanner(System.in);
        Scanner text = new Scanner(System.in);
        Scanner doble = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/dbProveedores/proveedoresdb.odb");
        EntityManager em = emf.createEntityManager();

        em.getTransaction()
                .begin();
        int i, j, k;

        do {
            System.out.println("Selecciona el objeto que quieras crear:"
                    + "\n1\tPieza"
                    + "\n2\tProveedor"
                    + "\notro\tSalir");
            i = num.nextInt();
            switch (i) {
                case 1:
                    Pieza pie = new Pieza();
                    System.out.println("Ingresa el nombre de la pieza");
                    pie.setNombre(text.nextLine());
                    System.out.println("Ingresa el material de la pieza");
                    pie.setMaterial(text.nextLine());
                    System.out.println("Ingresa el color de la pieza");
                    pie.setColor(text.nextLine());
                    System.out.println("Ingresa las dimensiones de la pieza");
                    pie.setDimenciones(text.nextLine());
                    System.out.println("Ingresa la descripción de la pieza");
                    pie.setDescripcion(text.nextLine());
                    System.out.println("Ingresa la categoría de la pieza");
                    pie.setCategoria(text.nextLine());
                    do {
                        System.out.println("Selecciona el objeto que quieras crear:"
                                + "\n1\tProveedorPieza"
                                + "\n2\tArticuloCompra");
                        j = num.nextInt();
                        switch (j) {
                            case 1:
                                ProveedorPieza proPie = new ProveedorPieza();
                                System.out.println("Ingresa el precio de la pieza");
                                proPie.setPrecio(doble.nextDouble());
                                pie.formPieza_proveedorPieza(proPie);
                                proPie.formProveedorPieza_pieza(pie);
                                em.persist(proPie);
                                System.out.println("¿Deseas agregar otro objeto de ProveedorPieza?"
                                        + "\n1\tno");
                                j = num.nextInt();
                                break;
                            case 2:
                                ArticuloCompra art = new ArticuloCompra();
                                System.out.println("Ingresa el subtotal de la compra");
                                art.setSubtotal(doble.nextDouble());
                                System.out.println("Ingresa el precio de la compra");
                                art.setPrecio(doble.nextDouble());
                                System.out.println("Ingresa el cantidad de la compra");
                                art.setCantidad(num.nextInt());
                                pie.formPieza_articuloCompra(art);
                                art.formArticuloCompra_proveedorPieza(pie);
                                em.persist(art);
                                System.out.println("¿Deseas agregar otro objeto de ArticuloCompra?"
                                        + "\n1\tno");
                                j = num.nextInt();
                                break;
                            default:
                                System.out.println("Ingresa un valor válido");
                        }
                    } while (j > 1 && j < 2);
                    em.persist(pie);
                    System.out.println("¿Deseas agregar otro objeto de Pieza?"
                            + "\n1\tno");
                    i = num.nextInt();
                    break;
                case 2:
                    Proveedor pro = new Proveedor();
                    System.out.println("Ingresa el nombre de la empresa del proveedor");
                    pro.setNomEmpresa(text.nextLine());
                    System.out.println("Ingresa el nombre del proveedor");
                    pro.setNomProveedor(text.nextLine());
                    System.out.println("Ingresa las coordenadas del proveedor");
                    pro.setCoordenadas(text.nextLine());
                    System.out.println("Ingresa la ciudad del proveedor");
                    pro.setCiudad(text.nextLine());
                    System.out.println("Ingresa el estado del proveedor");
                    pro.setEstado(text.nextLine());
                    System.out.println("Ingresa la dirección del proveedor");
                    pro.setDireccion(text.nextLine());
                    System.out.println("Ingresa el teléfono del proveedor");
                    pro.setTelefono(text.nextLine());
                    System.out.println("Ingresa el correo del proveedor");
                    pro.setCorreo(text.nextLine());
                    do {
                        System.out.println("Selecciona el objeto que quieras crear:"
                                + "\n1\tProveedorPieza"
                                + "\n2\tCompra");
                        j = num.nextInt();
                        switch (j) {
                            case 1:
                                ProveedorPieza proPie = new ProveedorPieza();
                                System.out.println("Ingresa el precio de la pieza");
                                proPie.setPrecio(doble.nextDouble());
                                pro.formProveedor_compra(proPie);
                                proPie.formProveedorPieza_proveedor(pro);
                                em.persist(proPie);
                                System.out.println("¿Deseas agregar otro objeto de ProveedorPieza?"
                                        + "\n1\tno");
                                j = num.nextInt();
                                break;
                            case 2:
                                Compra com = new Compra();
                                System.out.println("Ingresa el numero de factura de la compra");
                                com.setNoFactura(num.nextInt());
                                Date fecha = new Date();
                                System.out.println("Ingresa el año de la fecha de la compra");
                                fecha.setYear(num.nextInt());
                                System.out.println("Ingresa el mes de la fecha de la compra");
                                fecha.setMonth(num.nextInt());
                                System.out.println("Ingresa el día de la fecha de la compra");
                                fecha.setDate(num.nextInt());
                                com.setFecha(fecha);
                                System.out.println("Ingresa el total de la compra");
                                com.setTotal(num.nextInt());
                                pro.formProveedor_compra(com);
                                com.formCompra_proveedor(pro);
                                do {
                                    ArticuloCompra art = new ArticuloCompra();
                                    System.out.println("Ingresa el subtotal de la compra");
                                    art.setSubtotal(doble.nextDouble());
                                    System.out.println("Ingresa el precio de la compra");
                                    art.setPrecio(doble.nextDouble());
                                    System.out.println("Ingresa el cantidad de la compra");
                                    art.setCantidad(num.nextInt());
                                    com.formCompra_articuloCompra(art);
                                    art.formArticuloCompra_compra(com);
                                    em.persist(art);
                                    System.out.println("¿Deseas agregar otro objeto de ArticuloCompra?"
                                            + "\n1\tno");
                                    k = num.nextInt();
                                } while (k == 1);
                                System.out.println("¿Deseas agregar otro objeto de Compra?"
                                        + "\n1\tno");
                                j = num.nextInt();
                                break;
                            default:
                                System.out.println("Ingresa un valor válido");
                        }
                    } while (j > 1 && j < 2);
                    em.persist(pro);
                    System.out.println("¿Deseas agregar otro objeto de Proveedor?"
                            + "\n1\tno");
                    i = num.nextInt();
                    break;
                default:
                    System.out.println("Ingresa un valor válido");
            }
        } while (i > 1 && i
                < 2);
        em.getTransaction()
                .commit();
        em.close();

        emf.close();
    }
}