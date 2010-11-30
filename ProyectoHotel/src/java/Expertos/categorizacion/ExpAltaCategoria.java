/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.categorizacion;

import Entidades.Clase;
import Entidades.Tramo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Manuel
 */
@Remote
public interface  ExpAltaCategoria {

    public List<Clase> iniciarCU(Tramo tramo);
    public boolean guardarCategoria();
    public void agergarClase(Entidades.Clase clase, int antiguedadMinima, boolean inicial);
    public void agregarRequerimiento(String descripcion);
    public void agergarClase(Entidades.Clase clase, int antiguedadMinima);

}
