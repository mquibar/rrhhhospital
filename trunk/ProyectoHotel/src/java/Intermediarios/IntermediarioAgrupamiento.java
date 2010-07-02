/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Entidades.Agrupamiento;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author desarrollo
 */
@Remote
public interface IntermediarioAgrupamiento extends Intermediario{

    public void actualizar(Agrupamiento agrupamiento);
    public Agrupamiento findByName(String nombre);
    public List<Agrupamiento> findAll();
    public List<Agrupamiento> findAllOrder();
}
