/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intojpa.servicios;

import intojpa.Dao.ClienteDao;
import intojpa.entidades.Cliente;

/**
 *
 * @author santi
 */
public class ClienteService {
    
    private ClienteDao cdao = new ClienteDao();
    
    public void crear(Cliente cliente) throws Exception{
        try {
            cdao.crear(cliente);
        } catch (Exception e) {
            throw e;
        }
        
    }
}
