/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import DTO.DtoUsuario;
import Entidades.seguridad.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Manuel
 */
public class IntermediarioUsuario extends Intermediario<Usuario> {

    public IntermediarioUsuario() {
        _clase = "Usuario";
    }


    @Override
    public List<Usuario> findByDto(Object dto) {
        DtoUsuario dtoUs = (DtoUsuario) dto;
        Map<String, Object> restricciones = new HashMap<String, Object>();
        if(dtoUs.getNombre()!=null)
            restricciones.put("nombre", dtoUs.getNombre());
        if(dtoUs.getPassword()!=null)
            restricciones.put("password", dtoUs.getPassword());
        try {
            return(List<Usuario>) crearQuery(restricciones).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Usuario> findInOrden(String orden) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
