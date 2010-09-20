/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Manuel
 */
public interface  ExpAltaCategoria {

    public Map<String, List> iniciarAlta(String nombreCategoria);
    public boolean guardarCategoria();
    public void agergarClase(Entidades.Clase clase, int antiguedadMinima, boolean inicial);

    public void agergarClase(Entidades.Clase clase, int antiguedadMinima);

}
