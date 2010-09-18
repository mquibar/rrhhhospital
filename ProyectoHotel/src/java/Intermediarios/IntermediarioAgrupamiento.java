/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.Agrupamiento;
import java.util.List;

/**
 *
 * @author desarrollo
 */
public class IntermediarioAgrupamiento extends Intermediario<Agrupamiento>{

    public IntermediarioAgrupamiento() {
        _log = LogAdmin.getInstance().getLog(this.getClass());
        _clase = "Agrupamiento";
    }


    @Override
    public List<Agrupamiento> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
   
}
