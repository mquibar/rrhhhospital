/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.TipoLicencia;
import Intermediarios.IntermediarioTipoLicencia;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Desarrollo
 */
@Stateless
public class ExpConsultarTipoLicenciaBeans implements ExpConsultarTipoLicencia {


    public List<TipoLicencia> listar() {
        List<TipoLicencia> lista = (new IntermediarioTipoLicencia()).findAll();

        System.out.println("Listar TipoLicencia: " + lista.toString());
 
        return lista;
    }

}
