/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import DTO.DtoAgrupamiento;
import DTO.DtoRegistroPeriodo;
import DTO.DtoTramo;
import Entidades.Agrupamiento;
import Entidades.Empleado;
import Entidades.RegistroPeriodo;
import Entidades.Clase;
import Entidades.Tramo;
import Expertos.horario.ExpConsultarRegistroPeriodo;
import Intermediarios.IntermediarioAgrupamiento;
import Intermediarios.IntermediarioRegistroPeriodo;
import Intermediarios.IntermediarioClase;
import Intermediarios.IntermediarioTramo;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Desarrollo
 */
@Stateless
public class ExpConsultarRegistroPeriodoBeans implements ExpConsultarRegistroPeriodo {


    public List<RegistroPeriodo> listar() {
        return (new IntermediarioRegistroPeriodo()).findAll();
    }

    public List<RegistroPeriodo> listar(Empleado empleado) {
        IntermediarioRegistroPeriodo intermediario = new IntermediarioRegistroPeriodo();

        List<RegistroPeriodo> registroPeriodo;
        DtoRegistroPeriodo dto = new DtoRegistroPeriodo();
        dto.setIdEmpleado(empleado.getId());

        try
        {
            registroPeriodo = intermediario.findByDto(dto);
        } catch (NullPointerException e)
        {
            registroPeriodo=null;
        }

        dto=null;
        intermediario=null;
        
        return registroPeriodo;
    }

    public List<RegistroPeriodo> listar(Empleado empleado, int mes)
    {
        IntermediarioRegistroPeriodo intermediario = new IntermediarioRegistroPeriodo();

        List<RegistroPeriodo> registroPeriodo;
        DtoRegistroPeriodo dto = new DtoRegistroPeriodo();
        dto.setIdEmpleado(empleado.getId());
        dto.setMes(mes);

        try
        {
            registroPeriodo = intermediario.findByDto(dto);
        } catch (NullPointerException e)
        {
            registroPeriodo=null;
        }

        dto=null;
        intermediario=null;

        return registroPeriodo;
    }

    public RegistroPeriodo consultarAsignacionHorarioPorId(int id) {
        return (new IntermediarioRegistroPeriodo().findById(id));
    }

}
