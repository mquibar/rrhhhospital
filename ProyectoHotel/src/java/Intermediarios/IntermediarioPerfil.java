/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Entidades.seguridad.Perfil;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class IntermediarioPerfil extends Intermediario<Perfil> {

    public IntermediarioPerfil() {
        _clase="Perfil";
    }

    @Override
    public List<Perfil> findInOrden(String orden) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Perfil> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
