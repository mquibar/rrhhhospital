/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios.Beans;

import Intermediarios.*;
import Entidades.Tramo;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class IntermediarioTramoBean extends IntermediarioBeans<Tramo> implements IntermediarioTramo<Tramo> {

    @Override
    public List<Tramo> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
