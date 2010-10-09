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
import DTO.DTOProfesional;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
        DTOProfesional dtoProfesional = (DTOProfesional) dto;
        //Criteria c = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(Tramo.class);
        String query = "SELECT p FROM Profesional p WHERE ";
        if (dtoProfesional.getMatricula() != null) {
            query += "p.Matricula = :m";
            //c.createAlias("idAgrupamiento", "a");
            //c.add(Restrictions.eq("a", dtoTramo.getAgrupamiento()));
        }
        if (dtoProfesional.getNombre() != null) {
            query+=" AND p.nombre = :nombre";
            //c.add(Restrictions.eq("nombre", dtoTramo.getNombre()));
        }

        Query q = GestorConeccion.getInstance().getManager().createQuery(query);
        if(dtoProfesional.getMatricula()!=null)
            q.setParameter("m", dtoProfesional.getMatricula());
        if(dtoProfesional.getNombre()!=null)
            q.setParameter("nombre", dtoProfesional.getNombre());
        return q.getResultList();
    }

    public List <Profesional> findInOrder (String orden) {

        Criteria criterio = ((Session)GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(_clase).addOrder(Order.asc(orden));
        return criterio.list();
    }

    @Override
    public List<Profesional> findInOrden(String orden) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
