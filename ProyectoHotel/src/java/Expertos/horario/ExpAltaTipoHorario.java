/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import javax.ejb.Remote;

/**
 *
 * @author Manuel
 */
@Remote
public interface  ExpAltaTipoHorario {

    public void iniciarAlta (String idEntidad, Object ... data);

    public String guardar();

//    public void iniciarAlta (String idEntidad,
//        String nombre,
//        String descripcion,
//        Date horaIngreso,
//        Date horaSalida,
//        Boolean eliminado
//        );


}
