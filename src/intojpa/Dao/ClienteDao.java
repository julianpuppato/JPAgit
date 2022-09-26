/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intojpa.Dao;

import intojpa.entidades.Cliente;

/**
 *
 * @author santi
 */
public class ClienteDao extends Dao{
    public void crear(Cliente cliente) throws Exception{
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al persistir un libro");
        }
    }
    
    public void eliminar(Cliente cliente) throws Exception{
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al eliminar un libro");
        }
    }
}
