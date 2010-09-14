/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.Clase;
import java.util.List;

/**
 *
 * @author Manuel
 */
public interface  ExpAltaCategoria {

    public List<Clase> iniciarAlta(String nombreCategoria);
    public boolean guardarCategoria();
    public void agergarClase(Entidades.Clase clase, int antiguedadMinima, boolean inicial);

    public void agergarClase(Entidades.Clase clase, int antiguedadMinima);

}
