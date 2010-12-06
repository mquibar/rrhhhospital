/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario.consultar;

import DTO.DtoAsignacionHorario;
import Entidades.AsignacionHorario;
import Entidades.Empleado;
import Expertos.horario.consultar.ExpConsultarAsignacionHorario;
import Intermediarios.IntermediarioAsignacionHorario;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Desarrollo
 */
@Stateless
public class ExpConsultarAsignacionHorarioBeans implements ExpConsultarAsignacionHorario {


    public List<AsignacionHorario> listar() {
        return (new IntermediarioAsignacionHorario()).findAll();
    }

    public AsignacionHorario consultarAsignacionHorarioPorId(int id) {
        return (new IntermediarioAsignacionHorario().findById(id));
    }

    public List<AsignacionHorario> informeCronograma(Empleado emp, Date fechaIni, Date fechaFin)
    {
        DtoAsignacionHorario dto = new DtoAsignacionHorario();
        dto.setEmp(emp);
        dto.setFechaInicio(fechaIni);
        dto.setFechaFin(fechaFin);

        return (new IntermediarioAsignacionHorario().getCronograma(dto));
    }
}
