/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario.consultar;

import Entidades.Empleado;
import Entidades.Licencia;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Desarrollo
 */
@Remote
public interface  ExpConsultarLicencia
{

    public List<Licencia> listar();

    public List<Licencia> informeLicencias(Empleado emp, Date fechaIni, Date fechaFin);
}
