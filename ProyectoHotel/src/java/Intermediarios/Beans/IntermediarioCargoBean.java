/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios.Beans;

import Configuraciones.LogAdmin;
import Entidades.Cargo;
import Intermediarios.IntermediarioCargo;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Familia
 */
@Stateless
public class IntermediarioCargoBean extends IntermediarioBeans<Cargo> implements IntermediarioCargo<Cargo> {

    public IntermediarioCargoBean(){
        _clase="Cargo";
        _log=LogAdmin.getInstance().getLog(this.getClass());
    }
    @Override
    public List<Cargo> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Cargo> finAllInOrder(String order) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
