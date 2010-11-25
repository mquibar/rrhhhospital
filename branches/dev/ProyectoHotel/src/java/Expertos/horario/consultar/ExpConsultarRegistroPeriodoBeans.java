/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario.consultar;

import DTO.DtoRegistroPeriodo;
import Entidades.Empleado;
import Entidades.RegistroPeriodo;
import Intermediarios.IntermediarioRegistroPeriodo;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Desarrollo
 */
@Stateless
public class ExpConsultarRegistroPeriodoBeans implements ExpConsultarRegistroPeriodo {


    public List<RegistroPeriodo> listar()
    {
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

    public RegistroPeriodo consultarRegistroPeriodoPorId(int id) {
        return (new IntermediarioRegistroPeriodo().findById(id));
    }

}
