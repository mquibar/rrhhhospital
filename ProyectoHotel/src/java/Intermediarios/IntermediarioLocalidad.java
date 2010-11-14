/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import DTO.DtoLocalidades;
import Entidades.Localidad;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;

/**
 *
 * @author Juan
 */
public class IntermediarioLocalidad extends Intermediario <Localidad> {

    public IntermediarioLocalidad() {
        _clase = "Localidad";
        _log = LogAdmin.getInstance().getLog(this.getClass());

    }


    @Override
    public List<Localidad> findInOrden(String orden) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Localidad> findByDto(Object dto) {
        DtoLocalidades dtolocalidades = (DtoLocalidades) dto;
        Map<String,Object> restricciones = new HashMap<String, Object>();
        if (dtolocalidades.getProvincia() != null) {
            restricciones.put("idPovincia", dtolocalidades.getProvincia());
        }
        return crearQuery(restricciones).getResultList();

    }

     public Localidad findLocalidadByNombre (String nombre) {
     try {
            Query q = GestorConeccion.getInstance().getManager().createNamedQuery(_clase + ".findByNombre").setParameter(nombre, this);
            return (Localidad)q.getResultList().get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }
}
