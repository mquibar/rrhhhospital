/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.Domicilio;
import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Provincia;
import java.util.List;

/**
 *
 * @author Juan
 */
public class IntermediarioDomicilio extends Intermediario <Domicilio>{

    public IntermediarioDomicilio() {
        _clase = "Domicilio";
        _log = LogAdmin.getInstance().getLog(this.getClass());

    }

    @Override
    public List<Domicilio> findInOrden(String orden) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Domicilio> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
