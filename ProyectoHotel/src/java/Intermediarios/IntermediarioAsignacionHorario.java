/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import DTO.DtoAsignacionHorario;
import Entidades.AsignacionHorario;
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

public class IntermediarioAsignacionHorario extends Intermediario<AsignacionHorario> {

    public IntermediarioAsignacionHorario() {
        _clase="AsignacionHorario";
        _log = LogAdmin.getInstance().getLog(this.getClass());
    }


    @Override
    public List<AsignacionHorario> findByDto(Object dto) {
        DtoAsignacionHorario dtoCat = (DtoAsignacionHorario) dto;

        try
        {
            Criteria criteria = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(AsignacionHorario.class);

            criteria.add(Restrictions.eq("idEmpleado", dtoCat.getIdEmpleado()));
            
            if(dtoCat.getMes() != 0)
            {
                Date today = new Date();
                Date iniMes = new Date(today.getYear(), dtoCat.getMes(), 1);
                Date finMes = new Date(today.getYear(), dtoCat.getMes(), 31);

                criteria.add(Restrictions.between("Fecha", iniMes, finMes));
            }

            if(dtoCat.getIdTipoHorario() != 0)
            {
                criteria.add(Restrictions.eq("idTipoHorario", dtoCat.getIdTipoHorario()));
            }

            return criteria.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<AsignacionHorario> findInOrden(String orden)
    {
        Criteria criterio = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(AsignacionHorario.class).addOrder(Order.asc(orden));
        return criterio.list();
    }

    public AsignacionHorario findById(int id) {
        try
        {
            EntityManager em = GestorConeccion.getInstance().getManager();
            Query q = em.createNamedQuery(_clase + ".findById").setParameter("id", id);
            return (AsignacionHorario) q.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

}
