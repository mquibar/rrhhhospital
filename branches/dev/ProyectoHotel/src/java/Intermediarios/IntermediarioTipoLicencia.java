/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import DTO.DtoRegistroPeriodo;
import Entidades.RegistroPeriodo;
import Entidades.TipoLicencia;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Familia
 */

public class IntermediarioTipoLicencia extends Intermediario<TipoLicencia> {

    public IntermediarioTipoLicencia() {
        _clase="TipoLicencia";
        _log = LogAdmin.getInstance().getLog(this.getClass());
    }

    @Override
    public List<TipoLicencia> findInOrden(String orden)
    {
        Criteria criterio = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(TipoLicencia.class).addOrder(Order.asc(orden));
        return criterio.list();
    }

    @Override
    public List<TipoLicencia> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}