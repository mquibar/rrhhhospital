/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import DTO.DtoAgrupamiento;
import Entidades.Agrupamiento;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author desarrollo
 */
public class IntermediarioAgrupamiento extends Intermediario<Agrupamiento>{

    public IntermediarioAgrupamiento() {
        _log = LogAdmin.getInstance().getLog(this.getClass());
        _clase = "Agrupamiento";
    }


    @Override
    public List<Agrupamiento> findByDto(Object dto) {
        try {
            DtoAgrupamiento dtoAgrupamiento = (DtoAgrupamiento) dto;
            Query q = GestorConeccion.getInstance().getManager().createNamedQuery("Agrupamiento.findByNombre");
            q.setParameter("nombre", dtoAgrupamiento.getNombre());
            return q.getResultList();
        } catch (Exception ex) {
            System.out.println("**************** "+ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Agrupamiento> findInOrden(String orden) {
        Query q = GestorConeccion.getInstance().getManager().createQuery("SELECT a FROM "+ _clase + " a WHERE a.eliminado = :elim ORDER BY :orden");
        q.setParameter("elim", false);
        q.setParameter("orden", orden);
        return q.getResultList();
    }
   
}
