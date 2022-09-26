/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intojpa.Dao;

import intojpa.entidades.Prestamo;

/**
 *
 * @author santi
 */
public class PrestamoDao extends Dao{
    public void crear(Prestamo prestamo) throws Exception{
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(prestamo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al persistir un libro");
        }
    }
    
    public void eliminar(Prestamo prestamo) throws Exception{
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(prestamo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al eliminar un libro");
        }
    }
}
