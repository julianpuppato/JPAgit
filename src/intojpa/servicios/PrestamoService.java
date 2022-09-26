/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intojpa.servicios;

import intojpa.Dao.PrestamoDao;
import intojpa.entidades.Prestamo;

/**
 *
 * @author santi
 */
public class PrestamoService {
    private PrestamoDao pdao = new PrestamoDao();
    
    public void crear(Prestamo prestamo) throws Exception{
        try {
            pdao.crear(prestamo);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void devolucion(Prestamo prestamo){
        try {
            LibroService ls = new LibroService();
            ls.devolucion(prestamo.getLibro());
            pdao.eliminar(prestamo);
        } catch (Exception e) {
        }
    }
    
}
