/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import Entidades.seguridad.Perfil;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class ComboPerfil extends AbstractCombo<Perfil> {

    public ComboPerfil(List<Perfil> lista) {
        super(lista);
        for (Perfil perfil : lista) {
            addElement(perfil.getNombre());
        }
    }

}
