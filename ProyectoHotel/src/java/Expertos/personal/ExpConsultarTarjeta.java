/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import javax.ejb.Remote;

/**
 *
 * @author MARIANO
 */
@Remote
public interface ExpConsultarTarjeta {

    public Entidades.Tarjeta listarTarjetas(long numero);

    public java.util.List<Entidades.Tarjeta> listarTarjetasNoOcupadas();

}