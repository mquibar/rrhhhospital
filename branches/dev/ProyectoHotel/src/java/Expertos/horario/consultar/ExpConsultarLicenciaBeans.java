/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario.consultar;

import DTO.DtoLicencia;
import Entidades.Empleado;
import Entidades.Licencia;
import Intermediarios.IntermediarioLicencia;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Desarrollo
 */
@Stateless
public class ExpConsultarLicenciaBeans implements ExpConsultarLicencia {


    public List<Licencia> listar() {
        return (new IntermediarioLicencia()).findAll();
    }

    public Licencia consultarLicenciaPorId(int id) {
        return (new IntermediarioLicencia().findById(id));
    }


    public List<Licencia> informeLicencias(Empleado emp, Date fechaIni, Date fechaFin) {
        DtoLicencia dto = new DtoLicencia();
        dto.setEmpleado(emp);
        dto.setFechaInicio(fechaIni);
        dto.setFechaFin(fechaFin);

        return (new IntermediarioLicencia().informeLicencias(dto));
    }

}
