/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import DTO.DtoLicencia;
import DTO.DtoRegistroPeriodo;
import Entidades.Licencia;
import Entidades.RegistroPeriodo;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Familia
 */

public class IntermediarioLicencia extends Intermediario<Licencia> {

    public IntermediarioLicencia() {
        _clase="Licencia";
        _log = LogAdmin.getInstance().getLog(this.getClass());
    }


    @Override
    public List<Licencia> findByDto(Object dto) {
        DtoLicencia dtoCat = (DtoLicencia) dto;

        try
        {
            Criteria criteria = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(Licencia.class);

            criteria.add(Restrictions.eq("idEmpleado", dtoCat.getIdEmpleado()));
            
            if(dtoCat.getMes() != 0)
            {
                Date today = new Date();
                Date iniMes = new Date(today.getYear(), dtoCat.getMes(), 1);
                Date finMes = new Date(today.getYear(), dtoCat.getMes(), 31);

                criteria.add(Restrictions.or(
                        Restrictions.between("FechaEntrada", iniMes, finMes),
                        Restrictions.between("FechaEntrada", iniMes, finMes)
                        ));
            }

            if(dtoCat.getIdTipoLicencia() != 0)
            {
                criteria.add(Restrictions.eq("idTipoLicencia", dtoCat.getIdTipoLicencia()));
            }

            return criteria.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Licencia> findInOrden(String orden)
    {
        Criteria criterio = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(Licencia.class).addOrder(Order.asc(orden));
        return criterio.list();
    }

    public Licencia findById(int id) {
        try
        {
            EntityManager em = GestorConeccion.getInstance().getManager();
            Query q = em.createNamedQuery(_clase + ".findById").setParameter("id", id);
            return (Licencia) q.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

}
