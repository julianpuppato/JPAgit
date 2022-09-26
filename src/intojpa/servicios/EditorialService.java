/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intojpa.servicios;

import intojpa.Dao.EditorialDao;
import intojpa.entidades.Editorial;

/**
 *
 * @author santi
 */
public class EditorialService {
    private EditorialDao adao = new EditorialDao();

    public void crear(Editorial editorial) throws Exception {
        try {
            adao.crear(editorial);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
