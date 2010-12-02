/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import Entidades.Tarjeta;
import Intermediarios.IntermediarioTarjeta;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author MARIANO
 */
@Stateless
public class ExpConsultarTarjetaBeans implements ExpConsultarTarjeta {

    public Tarjeta listarTarjetas (long numero) {
        return ( new IntermediarioTarjeta().findByNumero(numero));
    }
    
    public List <Tarjeta> listarTarjetasNoOcupadas () {
        return (new Intermediarios.IntermediarioTarjeta()).findInOrden(null);
    }  

}
