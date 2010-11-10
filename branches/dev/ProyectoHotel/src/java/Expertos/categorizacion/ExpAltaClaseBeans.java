/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.categorizacion;

import DTO.DtoClase;
import Entidades.Clase;
import Expertos.categorizacion.ExpAltaClase;
import Intermediarios.IntermediarioClase;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Desarrollo
 */
@Stateless
public class ExpAltaClaseBeans implements ExpAltaClase{

    public boolean altaClase(String nombre) {
        nombre=nombre.toUpperCase();
        IntermediarioClase intermediario = new IntermediarioClase();
        boolean resultado = false;

        DtoClase dto = new DtoClase();
        dto.setNombre(nombre);
        Clase nueva = new Clase();
        nueva.setNombre(nombre);

        Intermediarios.GestorConeccion.getInstance().beginTransaction();
        List lista = intermediario.findByDto(dto);
        if(lista != null && lista.size()==0 ){
            try {
                resultado = intermediario.guardar(nueva);
                if (resultado) {
                    Intermediarios.GestorConeccion.getInstance().commitTransaction();
                }
                else
                    Intermediarios.GestorConeccion.getInstance().rollbackTransaction();
            } catch (Exception ex) {
                System.out.println("Error de Base de DAtos");
            }
        }
        else
            resultado = false;

        intermediario=null;
        dto=null;
        nueva=null;

        return resultado;
    }

}
