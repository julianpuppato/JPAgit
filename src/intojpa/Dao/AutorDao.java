/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intojpa.Dao;

import intojpa.entidades.Autor;

/**
 *
 * @author santi
 */
public class AutorDao extends Dao{
    public void crear(Autor autor) throws Exception{
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(autor);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al persistir un libro");
        }
    }
    
    public void eliminar(Autor autor) throws Exception{
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(autor);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al eliminar un libro");
        }
    }
}