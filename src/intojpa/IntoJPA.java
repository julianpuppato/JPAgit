/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intojpa;

import intojpa.entidades.Autor;
import intojpa.entidades.Cliente;
import intojpa.entidades.Editorial;
import intojpa.entidades.Libro;
import intojpa.entidades.Prestamo;
import intojpa.servicios.AutorService;
import intojpa.servicios.ClienteService;
import intojpa.servicios.EditorialService;
import intojpa.servicios.LibroService;
import intojpa.servicios.PrestamoService;
import java.util.Date;

/**
 *
 * @author santi
 */
public class IntoJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            AutorService as = new AutorService();
            Autor[] autores = new Autor[4];
            autores[0] = new Autor("Lorenzo");
            autores[1] = new Autor("Romina");
            autores[2] = new Autor("Ricardo");
            autores[3] = new Autor("Disney");
            for (int i = 0; i < autores.length; i++) {
                as.crear(autores[i]);
            }

            EditorialService es = new EditorialService();
            Editorial[] editoriales = new Editorial[4];
            editoriales[0] = new Editorial("Mapped");
            editoriales[1] = new Editorial("Billiken");
            editoriales[2] = new Editorial("Sugus");
            editoriales[3] = new Editorial("Channel");
            for (int i = 0; i < editoriales.length; i++) {
                es.crear(editoriales[i]);
            }

            LibroService ls = new LibroService();
            Libro[] libros = new Libro[4];
            libros[0]=new Libro(1L,"Principito", 2000, 10, 0,autores[0], editoriales[0]);
            libros[1]=new Libro(2L,"Harry Potter", 2010, 100, 0,autores[1], editoriales[1]);
            libros[2]=new Libro(3L,"La hechicera del Mediodia", 1990, 10, 0,autores[2], editoriales[2]);
            libros[3]=new Libro(4L,"Matilda", 2020, 200, 0,autores[3], editoriales[3]);
            for (int i = 0; i < libros.length; i++) {
                ls.crear(libros[i]);
            }
            
        ClienteService cs = new ClienteService();
            Cliente[] clientes = new Cliente[2];
//            clientes[0]=new Cliente(39845156L, "Alvaro", "Alzamora", "Venezuela 8132", "2617984054");
           clientes[1]=new Cliente(41991989L, "Santiago", "Alzamora", "Venezuela 8132", "2615798364");
//            for (int i = 0; i < clientes.length; i++) {
//                cs.crear(clientes[i]);
//            }
//            
//            
//
           PrestamoService ps = new PrestamoService();
           Prestamo[] prestamos = new Prestamo[3];
//            prestamos[0]=new Prestamo(new Date(121, 01, 20), new Date(121, 03, 20),libros[0],clientes[0]);
//            prestamos[1]=new Prestamo(new Date(120, 01, 20), new Date(121, 01, 20),libros[2],clientes[1]);
            prestamos[2]=new Prestamo(new Date(121, 02, 20), new Date(121, 03, 20),libros[0],clientes[1]);
//            for (int i = 0; i < prestamos.length; i++) {
//                ls.prestamo(prestamos[i].getLibro().getIsbn());             
//                ps.crear(prestamos[i]);
//            }
            ps.devolucion(prestamos[2]);
            
            ls.listarLibros();

        } catch (Exception e) {
            System.out.println(e.getMessage()); 

        }

    }

}
