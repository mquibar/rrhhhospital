/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Domicilio;
import Expertos.ExpAltaDomicilio;
import javax.ejb.Stateless;

/**
 *
 * @author Juan
 */
@Stateless
public class ExpAltaDomicilioBeans implements ExpAltaDomicilio {

    private Domicilio _domicilio;

    public ExpAltaDomicilioBeans() {
        _domicilio = new Domicilio();
    }

    public Domicilio altaDomicilio(String barrio, String calle, String numero, String piso, String departamanto, String localidad, String provincia) {
        _domicilio.setBarrio(barrio);
        _domicilio.setCalle(calle);
        _domicilio.setNumero(Integer.parseInt(numero));
        _domicilio.setPiso(piso);
        _domicilio.setDepartamento(departamanto);
        ExpConsultarDomicilioBeans experto = new ExpConsultarDomicilioBeans();
        _domicilio.setIdLocalidad(experto.consultarLocalidad(localidad));
        _domicilio.setIdProvincia(experto.consultarProvincia(provincia));

        return _domicilio;
    }
}
