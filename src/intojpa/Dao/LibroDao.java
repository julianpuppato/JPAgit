/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intojpa.Dao;

import intojpa.entidades.Libro;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author santi
 */
public class LibroDao extends Dao {

    public void crear(Libro libro) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(libro);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al persistir un libro");
        }
    }

    public void eliminar(Libro libro) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(libro);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al eliminar un libro");
        }
    }

    public void modificar(Libro libro) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(libro);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al modificar un libro");
        }
    }

    public List<Libro> buscarTodos() {
        return entityManager.createQuery("SELECT l FROM Libro l").getResultList();
    }

    public Libro buscarPorIsbn(Long isbn) {
        return (Libro) entityManager.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn").setParameter("isbn", isbn).getSingleResult();

    }

    public Libro buscarPorTitulo(String titulo) {
        try {
            return (Libro) entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo").setParameter("titulo", titulo).getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    public List<Libro> buscarPorAutor(String autor) {
        return entityManager.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre = :autor").setParameter("autor", autor).getResultList();
    }

}
