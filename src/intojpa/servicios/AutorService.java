/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intojpa.servicios;

import intojpa.Dao.AutorDao;
import intojpa.entidades.Autor;

/**
 *
 * @author santi
 */
public class AutorService {

    private AutorDao adao = new AutorDao();

    public void crear(Autor autor) throws Exception {
        try {
            adao.crear(autor);
        } catch (Exception e) {
            throw e;
        }
    }
}
