/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import DTO.DtoRegistroPeriodo;
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

public class IntermediarioRegistroPeriodo extends Intermediario<RegistroPeriodo> {

    public IntermediarioRegistroPeriodo() {
        _clase="RegistroPeriodo";
        _log = LogAdmin.getInstance().getLog(this.getClass());
    }


    @Override
    public List<RegistroPeriodo> findByDto(Object dto) {
        DtoRegistroPeriodo dtoCat = (DtoRegistroPeriodo) dto;

        try
        {
            Criteria criteria = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(RegistroPeriodo.class);

            if(dtoCat.getIdEmpleado() != 0)
            {
                criteria.add(Restrictions.eq("idEmpleado", dtoCat.getIdEmpleado()));
            }
            
            if(dtoCat.getFechaInicio() != null && dtoCat.getFechaFin() != null )
            {
                criteria.add(Restrictions.between("Fecha", dtoCat.getFechaInicio(), dtoCat.getFechaFin()));
            }
            
            if(dtoCat.getMes() != 0)
            {
                Date today = new Date();
                Date iniMes = new Date(today.getYear(), dtoCat.getMes(), 1);
                Date finMes = new Date(today.getYear(), dtoCat.getMes(), 31);

                criteria.add(Restrictions.between("FechaEntrada", iniMes, finMes));
            }

            return criteria.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<RegistroPeriodo> findInOrden(String orden)
    {
        Criteria criterio = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(RegistroPeriodo.class).addOrder(Order.asc(orden));
        return criterio.list();
    }

    public RegistroPeriodo findById(int id) {
        try
        {
            EntityManager em = GestorConeccion.getInstance().getManager();
            Query q = em.createNamedQuery(_clase + ".findById").setParameter("id", id);
            return (RegistroPeriodo) q.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

}
