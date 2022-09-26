/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intojpa.Dao;

import intojpa.entidades.Editorial;

/**
 *
 * @author santi
 */
public class EditorialDao extends Dao{
    public void crear(Editorial editorial) throws Exception{
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(editorial);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al persistir un libro");
        }
    }
    
    public void eliminar(Editorial editorial) throws Exception{
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(editorial);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al eliminar un libro");
        }
    }
}
