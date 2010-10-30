/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.Persona;
import java.util.List;

/**
 *
 * @author MARIANO
 */
public class IntermediarioPersona extends Intermediario <Persona> {

    public IntermediarioPersona() {
        _clase = "Persona";
        _log = LogAdmin.getInstance().getLog(this.getClass());
    }

    @Override
    public List<Persona> findInOrden(String orden) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Persona> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
