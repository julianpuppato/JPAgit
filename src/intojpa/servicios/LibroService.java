/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intojpa.servicios;

import intojpa.Dao.LibroDao;
import intojpa.entidades.Autor;
import intojpa.entidades.Editorial;
import intojpa.entidades.Libro;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author santi
 */
public class LibroService {

    private LibroDao ldao = new LibroDao();

    public void crear(Libro libro) throws Exception {
        Libro l = ldao.buscarPorIsbn(libro.getIsbn());
        
        if ( l != null ) {
            throw new Exception("El libro ya existe");
        }
        
        Libro l2= ldao.buscarPorTitulo(libro.getTitulo());
        if (l2 != null) {
            throw new Exception("Ya existe un libro con este titulo");
        }
        
        ldao.crear(libro);

    }

    private void modificar(Libro libro) throws Exception {
        try {
            ldao.modificar(libro);
        } catch (Exception e) {
            throw e;
        }
    }

    public void prestamo(Long isbn) throws Exception {
        try {
            Libro l = ldao.buscarPorIsbn(isbn);
            if (l.getPrestados() >= l.getEjemplares()) {
                throw new Exception("No quedan ejemplares para prestamo: " + l.getTitulo());
            }
            l.setPrestados(l.getPrestados() + 1);
            modificar(l);
        } catch (NoResultException e) {
            throw new NoResultException("No se encontro el Libro");
        }
    }

    public void devolucion(Libro libro) throws Exception {
        try {
            Libro l = ldao.buscarPorIsbn(libro.getIsbn());
            if (l != null) {
                if (l.getPrestados() == 0) {
                    throw new Exception("No hay prestamos activos de este libro: " + l.getTitulo());
                }
                l.setPrestados(l.getPrestados() - 1);
                modificar(l);
            } else {
                throw new Exception("El libro no existe");
            }

        } catch (NoResultException e) {
            throw new NoResultException("No se encontro el Libro");
        }

    }

    public void listarLibros() {
        List<Libro> l = ldao.buscarTodos();
        for (int i = 0; i < l.size(); i++) {
            mostrar(l.get(i));
        }

        mostrar(ldao.buscarPorIsbn(1L));
        mostrar(ldao.buscarPorTitulo("Matilda"));
    }

    public void mostrar(Libro libros) {
        System.out.println("Isbn: " + libros.getIsbn());
        System.out.println("Titulo: " + libros.getTitulo());
        System.out.println("Año: " + libros.getAnio());
        System.out.println("Ejemplares: " + libros.getEjemplares());
        System.out.println("Prestados: " + libros.getPrestados());
        System.out.println("Autor: " + libros.getAutor().getNombre());
        System.out.println("Editorial: " + libros.getEditorial().getNombre());
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");
    }

    public void verificarLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer prestados, Autor autor, Editorial editorial) throws Exception {
        try {

            if (isbn < 0) {
                throw new Exception("Isbn invalida");
            }
            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("Titulo invalido");
            }
            if (anio < 0) {
                throw new Exception("Año invalido");
            }
            if (ejemplares < 0) {
                throw new Exception("Cantidad de ejemplares invalida");
            }
            if (prestados < 0) {
                throw new Exception("Cantidad de prestados invalida");
            }
            if (autor == null) {
                throw new Exception("Autor invalido");
            }
            if (editorial == null) {
                throw new Exception("Editorial invalida");
            }

            if (ldao.buscarPorIsbn(isbn) != null) {
                throw new Exception("Esta isbn ya existe");
            }

        } catch (NoResultException e) {
            Libro libro = new Libro(isbn, titulo, anio, ejemplares, prestados, autor, editorial);
            ldao.crear(libro);
        }
    }

}
