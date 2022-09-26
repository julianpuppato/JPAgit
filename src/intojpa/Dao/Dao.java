/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intojpa.Dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author santi
 */
public class Dao {
    protected EntityManager entityManager = Persistence.createEntityManagerFactory("IntoJPAPU2").createEntityManager();
}
