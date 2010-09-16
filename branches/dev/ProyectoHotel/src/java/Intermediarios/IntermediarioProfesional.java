/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.Profesional;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author MARIANO
 */
public class IntermediarioProfesional extends Intermediario <Profesional> {

    public IntermediarioProfesional() {
        _clase = "Profesional";
        _log = LogAdmin.getInstance().getLog(this.getClass());


    }

    @Override
    public List findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List <Profesional> findInOrder (String orden) {

        Criteria criterio = ((Session)GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(_clase).addOrder(Order.asc(orden));
        return criterio.list();
    }

}
