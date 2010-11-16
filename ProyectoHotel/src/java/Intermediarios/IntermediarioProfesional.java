/*
 * Intermediario que se encarga de la comunicación con la base de datos
 * para persistir a un profesional
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.Profesional;
import java.util.List;
import DTO.DTOProfesional;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;


/**
 * Intermediario que persiste la entidad profesional
 *
 * @author Juan
 */
public class IntermediarioProfesional extends Intermediario <Profesional> {

    public IntermediarioProfesional() {
        _clase = "Profesional";
        _log = LogAdmin.getInstance().getLog(this.getClass());
    }

    /**
     * Redefine la busqueda por DTO, para consultas especificas de profesional
     *
     * @param dto
     * @return : devuelve a la lista de profesionales encontrado por los datos que le pasa el dto
     */
    @Override
    public List findByDto(Object dto) {
       DTOProfesional dtoPro = (DTOProfesional) dto;
       Map<String, Object> restricciones = new HashMap<String, Object>();

        if (dtoPro.getNombre() != null) {
            restricciones.put("nombre", dtoPro.getNombre());
        }
        if (dtoPro.getApellido() != null) {
            restricciones.put("apellido", dtoPro.getApellido());
        }
        if (dtoPro.getDni() != null) {
            restricciones.put("dni", dtoPro.getDni());
        }
        if (dtoPro.getMatricula() != null) {
            restricciones.put("matricula", dtoPro.getMatricula());
        }
        
        try {
            return crearQuery(restricciones).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Trae los profesionales listados por el parametro orden
     *
     * @param orden
     * @return : devuelve una lista de profesionales ordenados por el parametro
     */
    @Override
    public List<Profesional> findInOrden(String orden) {
        /*Criteria criterio = ((Session)GestorConeccion.getInstance().getManager().getDelegate()).createCriteria("Persona").addOrder(Order.asc(orden));
         try{return criterio.list();}catch(Exception ex){ex.printStackTrace();return null;}*/
        Query q = GestorConeccion.getInstance().getManager().createQuery("SELECT e FROM Profesional e WHERE e.eliminado is null ORDER by e."+orden);
        return q.getResultList();
    }

    public Profesional findByDni (String dni) {
            try {
            Query q = GestorConeccion.getInstance().getManager().createQuery("SELECT e FROM Profesional e WHERE e.dni = "+dni);
            return (Profesional)q.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

    public Profesional findByMatricula (String matricula) {
            try {
            Query q = GestorConeccion.getInstance().getManager().createNamedQuery(_clase + ".findByMatricula").setParameter("matricula", matricula);
            return (Profesional)q.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

    /**
     * Lista todos los profesionales del hospital que no estan eliminados
     * @return : retorna una lista con todos los profesionales del hospital
     */
    @Override
    public List<Profesional> findAll() {
        try {
            Query q = GestorConeccion.getInstance().getManager().createQuery("SELECT e FROM Profesional e WHERE e.eliminado is null");
            return q.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

}
