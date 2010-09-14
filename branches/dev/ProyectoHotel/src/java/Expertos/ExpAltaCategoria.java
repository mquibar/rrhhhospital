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
    public void agergarClase(Clase clase, int antiguedadMinima, boolean inicial);
    public void agergarClase(Clase clase, int antiguedadMinima);
    public boolean guardarCategoria();

}
