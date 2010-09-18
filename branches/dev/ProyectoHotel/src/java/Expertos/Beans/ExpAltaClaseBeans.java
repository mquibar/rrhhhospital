/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import DTO.DtoClase;
import Entidades.Clase;
import Expertos.ExpAltaClase;
import Intermediarios.IntermediarioClase;
import javax.ejb.Stateless;

/**
 *
 * @author Desarrollo
 */
@Stateless
public class ExpAltaClaseBeans implements ExpAltaClase{

    public boolean altaClase(String nombre) {
        IntermediarioClase intermediario = new IntermediarioClase();
        boolean resultado = false;

        DtoClase dto = new DtoClase();
        dto.setNombre(nombre);
        Clase nueva = new Clase();
        nueva.setNombre(nombre);

        if(intermediario.findByDto(dto) != null)
            resultado = intermediario.guardar(nueva);

        intermediario=null;
        dto=null;
        nueva=null;

        return resultado;
    }

}
