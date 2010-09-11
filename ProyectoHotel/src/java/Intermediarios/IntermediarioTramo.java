/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.Tramo;
import java.util.List;

/**
 *
 * @author Manuel
 */

public class IntermediarioTramo extends Intermediario<Tramo> {

    public IntermediarioTramo() {
        _log = LogAdmin.getInstance().getLog(this.getClass());
        _clase = "Tramo";
    }


    @Override
    public List<Tramo> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
